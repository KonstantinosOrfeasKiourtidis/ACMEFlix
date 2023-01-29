package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.transfer.resource.ProfileViewingHours;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileViewingHoursMapper extends BaseMapper<Profile, ProfileViewingHours>{
}
