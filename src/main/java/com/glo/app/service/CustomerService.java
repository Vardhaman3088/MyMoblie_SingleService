package com.glo.app.service;

import com.glo.app.dto.BasicDetailValidationDto;
import com.glo.app.dto.CustomeridentityDto;
import com.glo.app.dto.PersonalDetailValidationDto;
import com.glo.app.dto.SIMValidationDto;
import com.glo.app.entity.CustomerAddress;
import com.glo.app.entity.SimOffers;

public interface CustomerService {

    String validateSIM(SIMValidationDto simValidationDto);

    String validateBasicDetails(BasicDetailValidationDto basicDetailvalidationDto);

    String validatePersonalDetails(PersonalDetailValidationDto personalDetailValidationDto);

    CustomerAddress customerAddressValidation(CustomerAddress customerAddress, int uniqueId);
    String customerIdentityValidation(CustomeridentityDto customeridentityDto);

    SimOffers ShowOfferWithId(Integer simId);

    String ShowOrderinfo(Long uniqueId);

    String updateStatus(Integer simid);
}
