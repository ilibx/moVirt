package org.ovirt.mobile.movirt.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Api {
    public ProductInfo product_info;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class ProductInfo {
        public Version version;

        public Version getVersion() {
            return version;
        }
    }

    public org.ovirt.mobile.movirt.auth.properties.property.version.Version toVersion() {
        try {
            Version version = product_info.getVersion();
            return new org.ovirt.mobile.movirt.auth.properties.property.version.Version(Integer.parseInt(version.getMajor()),
                    Integer.parseInt(version.getMinor()),
                    Integer.parseInt(version.getBuild()));
        } catch (Exception x) {
            return new org.ovirt.mobile.movirt.auth.properties.property.version.Version(); // fallback versions are used instead
        }
    }
}
