insert into user_details(id, username, birth_date) values(100, 'thierry', CURRENT_DATE());
insert into user_details(id, username, birth_date) values(101, 'fabrice', CURRENT_DATE());
insert into user_details(id, username, birth_date) values(102, 'loudwige', CURRENT_DATE());
insert into user_details(id, username, birth_date) values(103, 'martine', CURRENT_DATE());

insert into requests(id, title, description, amount, user_id)
values(200, 'I really need your help', 'A tire in my car exploded and there is nothing that I can do about it, please help', 1500, 100);
insert into requests(id, title, description, amount, user_id)
values(201, 'In desperate need of help', 'This is insane I swear', 200, 100);
insert into requests(id, title, description, amount, user_id)
values(202, 'Anmweeyy', 'Oh oh gadon koze', 100, 100);
insert into requests(id, title, description, amount, user_id)
values(203, 'Kite Kompa Mache janw wel la', 'Anmwey mezanmi m bezwen aide nou sinon bahay yo ap red nan menm anpil', 1800, 100);


--     private Integer id;
-- @Size(min=5, message="The title should contain at least 5 characters")
--     private String title;
--     @Size(min=10, message = "Description should at least contain 10 characters")
--     private String description;
--     @Min(value=10, message = "The amount should be at least be 10 dollars")
--     private Integer amount;
--     @ManyToOne(fetch = FetchType.LAZY)
--     @JsonIgnore
--     private User user;