package com.ryana.domain;

import lombok.Getter;

@Getter
public enum AuthorityScope {
    ADMIN("SCOPE_ADMIN"),
    USER("SCOPE_USER");
    AuthorityScope(String scope) {
        this.scope = scope;
    }
    private final String scope;
}
