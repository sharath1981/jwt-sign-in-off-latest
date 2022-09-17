INSERT INTO app_user (username, password, enabled, account_non_expired, account_non_locked, credentials_non_expired) VALUES
('sharath', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', true, true, true, true),
('vivek', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', true, true, true, true),
('gopal', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', false, true, true, true),
('deb', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', true, false, true, true),
('soorya', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', true, true, false, true),
('ravi', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', true, true, true, false),
('rohit', '$2y$10$SVKUWxa0Z5uVYL4Adnp6lObmqG/FUIp5/AVavau9wMGY4otDGha62', false, false, false, false);
# password=pass

INSERT INTO authority (authority) VALUES
('ADMIN'),
('USER');

INSERT INTO app_user_authority(user_id, authority_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2);