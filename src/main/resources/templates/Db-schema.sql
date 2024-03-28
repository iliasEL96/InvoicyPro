create table accounting ( id bigint not null auto_increment, primary key (id), date date, benef_quotidien decimal(38,2), marge_quotidien float(53) not null, roas_quotidien float(53) not null, benef_total_avant_impot decimal(38,2), marge_avant_impot float(53) not null,   roas_total float(53) not null, chiffre_daffaire decimal(38,2),  duaurssaf decimal(38,2), benef_total_apres_impot decimal(38,2), marge_total_apres_impot float(53) not null, total_expenses decimal(38,2), total_revenues decimal(38,2), created_at datetime(6), updated_at datetime(6), is_refund bit) engine=InnoDB;

create table client (id bigint not null auto_increment, primary key (id), nom_complet varchar(255), email varchar(255), numero_telephone varchar(255)) engine=InnoDB;

create table expense (id bigint not null auto_increment,primary key (id),type enum ('PUBLICITE_FACEBOOK','PUBLICITE_INSTAGRAM','PUBLICITE_TIKTOK','COUT_PRODUITS','FRAIS_TRANSACTION_KLARNA','FRAIS_TRANSACTION_STRIPE','FRAIS_TRANSACTION_CHECKIFY','FRAIS_ANNULATION','SERVICE','LIVRAISON'), montant decimal(38,2), date date, created_at datetime(6), updated_at datetime(6), accounting_id bigint) engine=InnoDB;

create table order_details (id bigint not null auto_increment, primary key (id), date date, total_des_commandes integer not null) engine=InnoDB;

create table refund ( id bigint not null auto_increment, primary key (id), nom_complet varchar(255), montant_remboursement decimal(38,2),date_De_Commande date,date_De_Remboursement date, refund_method enum ('CARTE_CREDIT','PAYPAL','KLARNA','AUTRE'), refund_type enum ('PARTIEL','TOTAL'), accounting_id bigint, created_at datetime(6)time(6), updated_at datetime(6)) engine=InnoDB;

create table refund_client (client_id bigint not null, refund_id bigint not null) engine=InnoDB;

create table revenue (id bigint not null auto_increment, primary key (id), montant decimal(38,2) not null, revenue_type enum ('PAYPAL','KLARNA_MERCHANT','Credit_CARD','CHEKIFY_STRIPE','STRIPE'), date date, created_at datetime(6), updated_at datetime(6), accounting_id bigint, commande_id bigint) engine=InnoDB;

create table user (id bigint not null auto_increment, primary key (id), nom varchar(255), mot_de_passe varchar(255), role_type enum ('ADMIN','UTILISATEUR')) engine=InnoDB;

alter table expense add constraint FK9didad7m5eleas8hgfj5jf355 foreign key (accounting_id) references accounting (id);

alter table refund add constraint FKqna7s0i167j22bkm91vuk0qh1 foreign key (accounting_id) references accounting (id);

alter table refund_client add constraint FKibgeu7vfawrn8wic07w0j4ok8 foreign key (client_id) references client (id);

alter table refund_client add constraint FKsshykli1c7qcx0x9vyjfc4qc7 foreign key (refund_id) references refund (id);

alter table revenue add constraint FKifmtykp1j2rto4hyrbm42au5c foreign key (accounting_id) references accounting (id);

alter table revenue add constraint FKamafrn9t5g0dnk3tl2d1nlij2 foreign key (commande_id) references order_details (id);
