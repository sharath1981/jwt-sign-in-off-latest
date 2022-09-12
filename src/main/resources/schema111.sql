CREATE TABLE app_user
(
    id                      BIGINT AUTO_INCREMENT NOT NULL,
    username                VARCHAR(255)          NOT NULL,
    password                VARCHAR(255)          NOT NULL,
    account_non_expired     BIT(1)                NOT NULL,
    account_non_locked      BIT(1)                NOT NULL,
    credentials_non_expired BIT(1)                NOT NULL,
    enabled                 BIT(1)                NOT NULL,
    CONSTRAINT pk_app_user PRIMARY KEY (id)
);

CREATE TABLE authority
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    authority VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_authority PRIMARY KEY (id)
);

CREATE TABLE app_user_authority
(
    authority_id BIGINT NOT NULL,
    user_id      BIGINT NOT NULL,
    CONSTRAINT pk_app_user_authority PRIMARY KEY (authority_id, user_id)
);

ALTER TABLE app_user
    ADD CONSTRAINT uc_app_user_username UNIQUE (username);

ALTER TABLE authority
    ADD CONSTRAINT uc_authority_authority UNIQUE (authority);

ALTER TABLE app_user_authority
    ADD CONSTRAINT fk_appuseaut_on_app_user FOREIGN KEY (user_id) REFERENCES app_user (id);

ALTER TABLE app_user_authority
    ADD CONSTRAINT fk_appuseaut_on_authority FOREIGN KEY (authority_id) REFERENCES authority (id);