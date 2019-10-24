delete from provider where id = 0;
insert into provider values(0,"Team Edge","/about","Basking Ridge, NJ, USA","images/Prov_Team_Edge.png");

delete from item where prov_id = 0;
insert into item values(10,"EDGE Online Custom Mousepad","Special",15.99,50,"images/EDGE_MousePad.png",0);