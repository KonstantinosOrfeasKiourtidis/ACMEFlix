package com.team5.ACMEFlix.mapper;

import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.transfer.resource.ProfileResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends BaseMapper<Profile, ProfileResource>{

}