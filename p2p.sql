/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/9/26 16:09:47                           */
/*==============================================================*/


drop table if exists account;

drop table if exists accountReceivableLedger;

drop table if exists activationCodeTable;

drop table if exists adm;

drop table if exists adminMoneyChange;

drop table if exists authentication;

drop table if exists authenticationState;

drop table if exists bankCard;

drop table if exists bid;

drop table if exists fine;

drop table if exists integral;

drop table if exists integralRecord;

drop table if exists integralType;

drop table if exists loanRecord;

drop table if exists mailBox;

drop table if exists pledge;

drop table if exists rechargeRecord;

drop table if exists repaymentDetail;

drop table if exists replayRecord;

drop table if exists tradeState;

drop table if exists tradeType;

drop table if exists user;

drop table if exists withdrawDepositRecord;

/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
create table account
(
   accountId            int not null auto_increment,
   userId               int,
   balance              double,
   payPassword          varchar(100),
   primary key (accountId)
);

/*==============================================================*/
/* Table: accountReceivableLedger                               */
/*==============================================================*/
create table accountReceivableLedger
(
   detailId             int not null auto_increment,
   bidId                int,
   repayId              int,
   userId               int,
   stateId              int,
   receivablePrincipal  double,
   receivableInterest   double,
   receivableTotal      double,
   receivedDate         date,
   relMoney             double,
   relDate              date,
   handingCharge        double,
   primary key (detailId)
);

/*==============================================================*/
/* Table: activationCodeTable                                   */
/*==============================================================*/
create table activationCodeTable
(
   codeId               int not null auto_increment,
   userId               int,
   activationCode       varchar(100),
   activetionState      varchar(20),
   primary key (codeId)
);

/*==============================================================*/
/* Table: adm                                                   */
/*==============================================================*/
create table adm
(
   admId                int not null auto_increment,
   admName              varchar(20),
   admPwd               varchar(100),
   totalMoney           double,
   primary key (admId)
);

/*==============================================================*/
/* Table: adminMoneyChange                                      */
/*==============================================================*/
create table adminMoneyChange
(
   recordId             int not null auto_increment,
   admId                int,
   tradeNumber          double,
   tradeTime            date,
   useion               varchar(200),
   primary key (recordId)
);

/*==============================================================*/
/* Table: authentication                                        */
/*==============================================================*/
create table authentication
(
   aId                  int not null auto_increment,
   userId               int,
   personalPhoto        varchar(100),
   birthPlace           varchar(100),
   birthCard            varchar(100),
   hasChildren          varchar(20),
   userEducation        varchar(20),
   graduateSchool       varchar(100),
   graduateCard         varchar(100),
   marriageState        varchar(20),
   merryCard            varchar(100),
   roomCard             varchar(100),
   IDNumber             varchar(100),
   IDCardFront          varchar(100),
   IDCardBack           varchar(100),
   companyName          varchar(100),
   companyPlace         varchar(100),
   companyPhoto         varchar(100),
   position             varchar(100),
   workCard             varchar(100),
   monthlyIncome        double,
   IncomeCard           varchar(100),
   certifier            varchar(100),
   certifierPhone       varchar(100),
   primary key (aId)
);

/*==============================================================*/
/* Table: authenticationState                                   */
/*==============================================================*/
create table authenticationState
(
   authenticationId     int not null auto_increment,
   userId               int,
   authenticationName   varchar(100),
   addIntegral          int,
   state                varchar(100),
   passTime             date,
   primary key (authenticationId)
);

/*==============================================================*/
/* Table: bankCard                                              */
/*==============================================================*/
create table bankCard
(
   cardId               int not null auto_increment,
   accountId            int,
   cardNumber           varchar(100),
   bankType             varchar(100),
   primary key (cardId)
);

/*==============================================================*/
/* Table: bid                                                   */
/*==============================================================*/
create table bid
(
   bidId                int not null auto_increment,
   loanId               int,
   userId               int,
   tradeId              int,
   stateId              int,
   bidNumber            int,
   allBid               double,
   bidTime              date,
   handingCharge        double,
   getInterest          double,
   totalMoney           double,
   receivedMoney        double,
   dueInMoney           double,
   primary key (bidId)
);

/*==============================================================*/
/* Table: fine                                                  */
/*==============================================================*/
create table fine
(
   fineId               int not null auto_increment,
   repayId              int,
   userId               int,
   overdueDays          int,
   fineNumber           double,
   primary key (fineId)
);

/*==============================================================*/
/* Table: integral                                              */
/*==============================================================*/
create table integral
(
   integralId           int not null auto_increment,
   userId               int,
   integralNumber       double,
   primary key (integralId)
);

/*==============================================================*/
/* Table: integralRecord                                        */
/*==============================================================*/
create table integralRecord
(
   recordId             int not null auto_increment,
   userId               int,
   integralId           int,
   typeId               int,
   integralChange       int,
   recordDate           date,
   primary key (recordId)
);

/*==============================================================*/
/* Table: integralType                                          */
/*==============================================================*/
create table integralType
(
   typeId               int not null auto_increment,
   typeName             varchar(20),
   primary key (typeId)
);

/*==============================================================*/
/* Table: loanRecord                                            */
/*==============================================================*/
create table loanRecord
(
   loanId               int not null auto_increment,
   userId               int,
   tradeId              int,
   stateId              int,
   projectName          varchar(100),
   loanMoney            double,
   interestRate         double,
   loanLife             varchar(20),
   buyBackLife          varchar(20),
   releaseDate          date,
   handingCharge        double,
   payUp                double,
   allReplay            double,
   hasReplay            double,
   bidNumber            int,
   purpose              varchar(200),
   remark               varchar(200),
   hasBidNumber         int,
   primary key (loanId)
);

/*==============================================================*/
/* Table: mailBox                                               */
/*==============================================================*/
create table mailBox
(
   mailId               int not null auto_increment,
   userId               int,
   theme                varchar(100),
   content              varchar(100),
   classify             varchar(100),
   receiveTime          date,
   hasRead              varchar(100),
   primary key (mailId)
);

/*==============================================================*/
/* Table: pledge                                                */
/*==============================================================*/
create table pledge
(
   pledgeId             int not null auto_increment,
   userId               int,
   pledgeName           varchar(20),
   pledgePhoto          varchar(20),
   valution             double,
   primary key (pledgeId)
);

/*==============================================================*/
/* Table: rechargeRecord                                        */
/*==============================================================*/
create table rechargeRecord
(
   RecordId             int not null auto_increment,
   accountId            int,
   cardId               int,
   stateId              int,
   tradeId              int,
   rechargeNumber       double,
   rTime                date,
   remark               varchar(200),
   primary key (RecordId)
);

/*==============================================================*/
/* Table: repaymentDetail                                       */
/*==============================================================*/
create table repaymentDetail
(
   repayId              int not null auto_increment,
   userId               int,
   loanId               int,
   stateId              int,
   periods              int,
   repayInterest        double,
   repayPrincipal       double,
   totalRepay           double,
   repayDate            date,
   relDate              date,
   relMoney             double,
   primary key (repayId)
);

/*==============================================================*/
/* Table: replayRecord                                          */
/*==============================================================*/
create table replayRecord
(
   replayId             int not null auto_increment,
   loanId               int,
   userId               int,
   stateId              int,
   tradeId              int,
   replayMoney          double,
   replayDate           date,
   integralChange       double,
   primary key (replayId)
);

/*==============================================================*/
/* Table: tradeState                                            */
/*==============================================================*/
create table tradeState
(
   stateId              int not null auto_increment,
   stateName            varchar(20),
   primary key (stateId)
);

/*==============================================================*/
/* Table: tradeType                                             */
/*==============================================================*/
create table tradeType
(
   tradeId              int not null auto_increment,
   tradeName            varchar(20),
   primary key (tradeId)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userId               int not null auto_increment,
   userName             varchar(20),
   userPassword         varchar(100),
   userTName            varchar(20),
   sex                  varchar(10),
   Birthday             date,
   PhoneNumber          varchar(100),
   mail                 varchar(100),
   userPicture          varchar(100),
   place                varchar(100),
   lastEnterTime        date,
   primary key (userId)
);

/*==============================================================*/
/* Table: withdrawDepositRecord                                 */
/*==============================================================*/
create table withdrawDepositRecord
(
   wdId                 int not null auto_increment,
   accountId            int,
   stateId              int,
   tradeId              int,
   cardId               int,
   wdNumber             double,
   wdTime               date,
   primary key (wdId)
);

alter table account add constraint FK_Reference_41 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table accountReceivableLedger add constraint FK_Reference_32 foreign key (bidId)
      references bid (bidId) on delete restrict on update restrict;

alter table accountReceivableLedger add constraint FK_Reference_33 foreign key (repayId)
      references repaymentDetail (repayId) on delete restrict on update restrict;

alter table accountReceivableLedger add constraint FK_Reference_34 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table accountReceivableLedger add constraint FK_Reference_35 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table activationCodeTable add constraint FK_Reference_2 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table adminMoneyChange add constraint FK_Reference_40 foreign key (admId)
      references adm (admId) on delete restrict on update restrict;

alter table authentication add constraint FK_Reference_1 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table authenticationState add constraint FK_Reference_3 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table bankCard add constraint FK_Reference_10 foreign key (accountId)
      references account (accountId) on delete restrict on update restrict;

alter table bid add constraint FK_Reference_19 foreign key (tradeId)
      references tradeType (tradeId) on delete restrict on update restrict;

alter table bid add constraint FK_Reference_20 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table bid add constraint FK_Reference_21 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table bid add constraint FK_Reference_22 foreign key (loanId)
      references loanRecord (loanId) on delete restrict on update restrict;

alter table fine add constraint FK_Reference_37 foreign key (repayId)
      references repaymentDetail (repayId) on delete restrict on update restrict;

alter table fine add constraint FK_Reference_38 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table integral add constraint FK_Reference_6 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table integralRecord add constraint FK_Reference_7 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table integralRecord add constraint FK_Reference_8 foreign key (integralId)
      references integral (integralId) on delete restrict on update restrict;

alter table integralRecord add constraint FK_Reference_9 foreign key (typeId)
      references integralType (typeId) on delete restrict on update restrict;

alter table loanRecord add constraint FK_Reference_23 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table loanRecord add constraint FK_Reference_24 foreign key (tradeId)
      references tradeType (tradeId) on delete restrict on update restrict;

alter table loanRecord add constraint FK_Reference_25 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table mailBox add constraint FK_Reference_4 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table pledge add constraint FK_Reference_39 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table rechargeRecord add constraint FK_Reference_11 foreign key (accountId)
      references account (accountId) on delete restrict on update restrict;

alter table rechargeRecord add constraint FK_Reference_12 foreign key (cardId)
      references bankCard (cardId) on delete restrict on update restrict;

alter table rechargeRecord add constraint FK_Reference_13 foreign key (tradeId)
      references tradeType (tradeId) on delete restrict on update restrict;

alter table rechargeRecord add constraint FK_Reference_14 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table repaymentDetail add constraint FK_Reference_30 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table repaymentDetail add constraint FK_Reference_31 foreign key (loanId)
      references loanRecord (loanId) on delete restrict on update restrict;

alter table repaymentDetail add constraint FK_Reference_36 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table replayRecord add constraint FK_Reference_26 foreign key (loanId)
      references loanRecord (loanId) on delete restrict on update restrict;

alter table replayRecord add constraint FK_Reference_27 foreign key (userId)
      references user (userId) on delete restrict on update restrict;

alter table replayRecord add constraint FK_Reference_28 foreign key (tradeId)
      references tradeType (tradeId) on delete restrict on update restrict;

alter table replayRecord add constraint FK_Reference_29 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table withdrawDepositRecord add constraint FK_Reference_15 foreign key (tradeId)
      references tradeType (tradeId) on delete restrict on update restrict;

alter table withdrawDepositRecord add constraint FK_Reference_16 foreign key (stateId)
      references tradeState (stateId) on delete restrict on update restrict;

alter table withdrawDepositRecord add constraint FK_Reference_17 foreign key (accountId)
      references account (accountId) on delete restrict on update restrict;

alter table withdrawDepositRecord add constraint FK_Reference_18 foreign key (cardId)
      references bankCard (cardId) on delete restrict on update restrict;

