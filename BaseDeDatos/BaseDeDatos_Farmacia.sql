/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/09/2019 01:32:18 p.m.                     */
/*==============================================================*/


drop table if exists AdminFarmacia;

drop table if exists AdminAlmacen;

drop table if exists Cliente;

drop table if exists Contrato;

drop table if exists Vendedor;

drop table if exists LoginEmpleado;

drop table if exists Medicamento;

drop table if exists Promocion;

drop table if exists Proveedor;

drop table if exists Relacion_1;

drop table if exists Relacion_2;

drop table if exists Relacion_3;

drop table if exists Reserva;

drop table if exists Venta;

/*==============================================================*/
/* Table: AdminFarmacia                               */
/*==============================================================*/
create table AdminFarmacia
(
   IDADMINISTRADORFARMACIA varchar(25) not null,
   NOMBREADMINISTRADODEFARMACIA varchar(50) not null,
   CIAdminFarmacia varchar(15) not null,
   CELULARAdminFarmacia varchar(15) not null,
   DIRECCIONVendedor varchar(50) not null,
   primary key (IDADMINISTRADORFARMACIA)
);

/*==============================================================*/
/* Table: AdminAlmacen                                */
/*==============================================================*/
create table AdminAlmacen
(
   IDADMINISTRADORDEALMACEN varchar(20) not null,
   CIADMINISTRADORDEALMACEN varchar(15) not null,
   NOMBREADMINISTRADORDELAMLACEN varchar(50) not null,
   DIRECCIONADMINISTRADORDELALMACEN varchar(50) not null,
   CELULARDEADMINISTRADORDEALMACEN varchar(10),
   primary key (IDADMINISTRADORDEALMACEN)
);

/*==============================================================*/
/* Table: Cliente                                               */
/*==============================================================*/
create table Cliente
(
   IDCliente            varchar(25) not null,
   CARNETDEIDENTIDADCliente varchar(25) not null,
   NOMBREPACIENTE       varchar(50) not null,
   ENFERMEDAD           varchar(200),
   LoginEmpleado        varchar(15) not null,
   PASSWORD             varchar(15) not null,
   primary key (IDCliente)
);

/*==============================================================*/
/* Table: Contrato                                              */
/*==============================================================*/
create table Contrato
(
   IDContrato           varchar(25) not null,
   IDVendedor       varchar(25) not null,
   IDADMINISTRADORDEALMACEN varchar(20) not null,
   PAGOMENSUAL          float(8,2) not null,
   primary key (IDContrato)
);

/*==============================================================*/
/* Table: Vendedor                                         */
/*==============================================================*/
create table Vendedor
(
   IDVendedor       varchar(25) not null,
   CIVendedor       varchar(25) not null,
   NOMBREVendedor   varchar(50) not null,
   DIRECCIONVendedor varchar(50) not null,
   CELULARVendedor  varchar(10),
   primary key (IDVendedor)
);

/*==============================================================*/
/* Table: LoginEmpleado                                         */
/*==============================================================*/
create table LoginEmpleado
(
   IDLoginEmpleado      varchar(25) not null,
   IDADMINISTRADORFARMACIA varchar(25) not null,
   IDVendedor       varchar(25) not null,
   IDADMINISTRADORDEALMACEN varchar(20) not null,
   LoginEmpleado        varchar(15) not null,
   PASSEMPLEADO         varchar(15) not null,
   CARGO                varchar(25) not null,
   primary key (IDLoginEmpleado)
);

/*==============================================================*/
/* Table: Medicamento                                           */
/*==============================================================*/
create table Medicamento
(
   IDMedicamento        varchar(50) not null,
   NOMBREMedicamento    varchar(50) not null,
   CODIGOSENASAG        varchar(20) not null,
   PREESCRIPCION        bool not null,
   PRECIO               float(8,2) not null,
   PRECIODEVenta        float(8,2) not null,
   DOSIS                int not null,
   primary key (IDMedicamento)
);

/*==============================================================*/
/* Table: Promocion                                             */
/*==============================================================*/
create table Promocion
(
   IDPromocion          varchar(20) not null,
   NOMBREDEPromocion    varchar(30) not null,
   TIPODEPromocion      varchar(20) not null,
   primary key (IDPromocion)
);

/*==============================================================*/
/* Table: Proveedor                                             */
/*==============================================================*/
create table Proveedor
(
   IDProveedor          varchar(20) not null,
   IDMedicamento        varchar(50) not null,
   TIPODEPROVEEDDOR     varchar(20) not null,
   CORREOELECTRONICOProveedor varchar(40) not null,
   primary key (IDProveedor)
);

/*==============================================================*/
/* Table: Relacion_1                                        */
/*==============================================================*/
create table Relacion_1
(
   IDVenta              varchar(30) not null,
   IDMedicamento        varchar(50) not null,
   primary key (IDVenta, IDMedicamento)
);

/*==============================================================*/
/* Table: Relacion_2                                       */
/*==============================================================*/
create table Relacion_2
(
   IDMedicamento        varchar(50) not null,
   IDPromocion          varchar(20) not null,
   primary key (IDMedicamento, IDPromocion)
);

/*==============================================================*/
/* Table: Relacion_3                                        */
/*==============================================================*/
create table Relacion_3
(
   IDMedicamento        varchar(50) not null,
   IDReserva            varchar(25) not null,
   primary key (IDMedicamento, IDReserva)
);

/*==============================================================*/
/* Table: Reserva                                               */
/*==============================================================*/
create table Reserva
(
   IDReserva            varchar(25) not null,
   IDCliente            varchar(25) not null,
   FECHAReserva         date not null,
   HORAReserva          time not null,
   primary key (IDReserva)
);

/*==============================================================*/
/* Table: Venta                                                 */
/*==============================================================*/
create table Venta
(
   IDVenta              varchar(30) not null,
   IDVendedor       varchar(25) not null,
   IDCliente            varchar(25) not null,
   HORADEVenta          time not null,
   FECHADEVenta         date not null,
   TOTAL                float(8,2) not null,
   primary key (IDVenta)
);

alter table Contrato add constraint FK_Relacion_10 foreign key (IDADMINISTRADORDEALMACEN)
      references AdminAlmacen (IDADMINISTRADORDEALMACEN) on delete restrict on update restrict;

alter table Contrato add constraint FK_RELATIONSHIP_9 foreign key (IDVendedor)
      references Vendedor (IDVendedor) on delete restrict on update restrict;

alter table LoginEmpleado add constraint FK_Relacion_17 foreign key (IDADMINISTRADORFARMACIA)
      references AdminFarmacia (IDADMINISTRADORFARMACIA) on delete restrict on update restrict;

alter table LoginEmpleado add constraint FK_Relacion_18 foreign key (IDVendedor)
      references Vendedor (IDVendedor) on delete restrict on update restrict;

alter table LoginEmpleado add constraint FK_Relacion_19 foreign key (IDADMINISTRADORDEALMACEN)
      references AdminAlmacen (IDADMINISTRADORDEALMACEN) on delete restrict on update restrict;

alter table Proveedor add constraint FK_RELATIONSHIP_6 foreign key (IDMedicamento)
      references Medicamento (IDMedicamento) on delete restrict on update restrict;

alter table Relacion_1 add constraint FK_Relacion_1 foreign key (IDVenta)
      references Venta (IDVenta) on delete restrict on update restrict;

alter table Relacion_1 add constraint FK_RELATIONSHIP_7 foreign key (IDMedicamento)
      references Medicamento (IDMedicamento) on delete restrict on update restrict;

alter table Relacion_2 add constraint FK_Relacion_2 foreign key (IDMedicamento)
      references Medicamento (IDMedicamento) on delete restrict on update restrict;

alter table Relacion_2 add constraint FK_RELATIONSHIP_20 foreign key (IDPromocion)
      references Promocion (IDPromocion) on delete restrict on update restrict;

alter table Relacion_3 add constraint FK_Relacion_3 foreign key (IDMedicamento)
      references Medicamento (IDMedicamento) on delete restrict on update restrict;

alter table Relacion_3 add constraint FK_RELATIONSHIP_8 foreign key (IDReserva)
      references Reserva (IDReserva) on delete restrict on update restrict;

alter table Reserva add constraint FK_RELATIONSHIP_5 foreign key (IDCliente)
      references Cliente (IDCliente) on delete restrict on update restrict;

alter table Venta add constraint FK_RELATIONSHIP_2 foreign key (IDVendedor)
      references Vendedor (IDVendedor) on delete restrict on update restrict;

alter table Venta add constraint FK_RELATIONSHIP_3 foreign key (IDCliente)
      references Cliente (IDCliente) on delete restrict on update restrict;

