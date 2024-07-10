package com.glo.app.service;

import com.glo.app.dto.BasicDetailValidationDto;
import com.glo.app.dto.CustomeridentityDto;
import com.glo.app.dto.PersonalDetailValidationDto;
import com.glo.app.dto.SIMValidationDto;
import com.glo.app.entity.*;
import com.glo.app.exception.CustomerNotFound;
import com.glo.app.exception.InvalidSimServiceNumber;
import com.glo.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerAddressRepository customerAddressRepository;

    @Autowired
    CustomerIdentityRepository customerIdentityRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SimDetailsRepository simDetailsRepository;

    @Autowired
    SimOffersRepository simOffersRepository;


    @Override
    public String validateSIM(SIMValidationDto simValidationDto)  {

        Optional<SimDetails> simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(simValidationDto.getServiceNumber(), simValidationDto.getSimNumber());
        if(simDetails.isPresent()){
            if(simDetails.get().getSimStatus().equalsIgnoreCase("active")){
                return "SIM aleady active";
            }else{
                simDetailsRepository.updateSimStatusBySimId(simDetails.get().getSimId());
                return "Valid Details Welcome";
            }
        }
        else{
            throw new InvalidSimServiceNumber("Enter the valid Sim Number and the service number");
        }
    }

    @Override
    public String validateBasicDetails(BasicDetailValidationDto basicDetailvalidationDto) {
        Optional<Customer> customer = customerRepository.findByEmailAddressAndDateOfBirth(basicDetailvalidationDto.getEmailAddress(), basicDetailvalidationDto.getDateOfBirth());
        if(customer.isPresent()){
            return "Validated Successfully";
        }else{
            return "No request placed for you.";
        }
    }

    @Override
    public String validatePersonalDetails(PersonalDetailValidationDto personalDetailValidationDto) {
        Optional<Customer> customer = customerRepository.findByFirstNameAndLastName(personalDetailValidationDto.getFirstName(), personalDetailValidationDto.getLastname());

        if(!customer.isPresent())
            return "Given FirstName and Last Name is not present in the table";

        if(customer.get().getEmailAddress().equals(personalDetailValidationDto.getConfirmEmail())){
            return "Email Address validated Succefully";
        }else{
            return  "Email Address is not Validated Successfully";
        }
    }

    @Override
    public CustomerAddress customerAddressValidation(CustomerAddress customerAddress, int uniqueId) {
        customerAddressRepository.save(customerAddress);
        return customerAddress;
    }

    @Override
    public String customerIdentityValidation(CustomeridentityDto customeridentityDto) {
        long givenid = customeridentityDto.getUniqueIdNumber();
        String givenDOB = customeridentityDto.getDateOfBirth();
        String givenFirstName = customeridentityDto.getFirstName();
        String givenLastName = customeridentityDto.getLastName();
        String givenState = customeridentityDto.getState();
        String givenEmail = customeridentityDto.getEmailAddress();
        String givenIdType = customeridentityDto.getId_type();
        Optional<Customer> cust = customerRepository.findById(givenid);
        if(!cust.isPresent()){
            return "Details are wroung";
        }else if(givenDOB.equals(cust.get().getDateOfBirth()) && givenFirstName.equals(cust.get().getFirstName()) && givenLastName.equals(cust.get().getLastName()) && givenState.equals(cust.get().getState()) && givenEmail.equals(cust.get().getEmailAddress()) && givenIdType.equals(cust.get().getIdType())){
            return "Details are validated";
        }else {
            return "Details are wrong";
        }
    }

    @Override
    public SimOffers ShowOfferWithId(Integer simID){
        return simOffersRepository.findById(simID).get();
    }

    @Override
    public String ShowOrderinfo(Long uniqueId){
        Optional<Customer> customer = customerRepository.findById(uniqueId);
        if(!customer.isPresent()){
            throw new CustomerNotFound("No Customer Found With Your Unique Id");
        }
        SimDetails simDetails= customer.get().getSimDetails();
        Optional<SimOffers> simOffers = simOffersRepository.findById(simDetails.getSimId());
        return customer.get().getFirstName() +" "+customer.get().getLastName()+" "+customer.get().getEmailAddress()+" "+customer.get().getDateOfBirth()+" "+simOffers.get().getOfferName() + simDetails.getSimStatus();
    }

    @Override
    public String updateStatus(Integer simid){
        simDetailsRepository.updateSimStatusBySimId(simid);
        return "Status updated Successfully";

    }
}
