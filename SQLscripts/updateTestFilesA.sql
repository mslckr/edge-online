update provider set prov_addr = "Round Rock, Texas, USA" where id = 1243;
update provider set prov_addr = "Palo Alto, CA, USA" where id = 5923;
update provider set prov_addr = "Carlsbad, CA, USA" where id = 71;
update provider set prov_link = "https://www.dell.com/en-us" where id = 1243;
update provider set prov_link = "https://hp.com/country/us/en/welcome.html" where id = 5923;
update provider set prov_link = "https://www.razer.com/Store" where id = 71;
update provider set prov_logo = "images/Prov_Dell.png" where id = 1243;
update provider set prov_logo = "images/Prov_HP.png" where id = 5923;
update provider set prov_logo = "images/Prov_Razer.png" where id = 71;

update item set item_img = "images/Area_51_Threadripper.png" where id = 1;
update item set item_img = "images/Area_51_Laptop.png" where id = 3;
update item set item_img = "images/Pavilion_Tower.png" where id = 2;
update item set item_img = "images/Blackwidow_Elite.png" where id = 4;
update item set item_img = "images/Deathadder_Elite.png" where id = 5;