package com.service.shorter.vm.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkVm {
    String url;


    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
