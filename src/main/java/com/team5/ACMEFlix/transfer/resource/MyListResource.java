package com.team5.ACMEFlix.transfer.resource;

import com.team5.ACMEFlix.domain.Content;
import com.team5.ACMEFlix.domain.Profile;
import com.team5.ACMEFlix.transfer.BaseResource;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class MyListResource extends BaseResource {

    private Profile profile;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ContentResource> contents;
}
