package com.P8.rewardCentral.Controller;

import com.P8.rewardCentral.DTO.RewardPointsDTO;
import com.P8.rewardCentral.Exceptions.UserIdException;
import com.P8.rewardCentral.Service.RewardCentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RewardCentralController {

    @Autowired
    RewardCentralService rewardCentralService;

    @GetMapping("/")
    public String rewardCentral() {
        return "P8 RewardCentral Home";
    }

    @GetMapping("/attractionrewardpoints")
    public RewardPointsDTO getAttractionRewardPoints(@RequestParam String attractionId, @RequestParam String userId) throws UserIdException {
        if (attractionId.isEmpty() || userId.isEmpty()) {
            throw new UserIdException("The parameters attractionId  and userId are mandatory");
        }
        Integer points = rewardCentralService.getAttractionRewardPoints(UUID.fromString(attractionId), UUID.fromString(userId));
        RewardPointsDTO rewardPointsDTO = new RewardPointsDTO(points);
        return rewardPointsDTO;
    }
}
