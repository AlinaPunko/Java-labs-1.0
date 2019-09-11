 use master 
 create database Lab8
 on primary
(name =N'Lab8_mdf', filename=N'E:\����\���\Lab8\Lab8_mdf.mdf',
size = 5120Kb, maxsize=10240Kb,filegrowth=1024Kb),
(name =N'Lab8_ndf', filename=N'E:\����\���\Lab8\Lab8_ndf.ndf',
size = 5120Kb, maxsize=10240Kb,filegrowth=10%)
log on
(name =N'Lab8_log', filename=N'E:\����\���\Lab8\Lab8_log.ldf',
size = 5Mb, maxsize=unlimited,filegrowth=10%);
use Lab8;
create table Man 
(FIO nvarchar(30) constraint FIO_PK primary key , Date_of_birth date);
create table Letter 
(ID int primary key, Sender nvarchar(30) constraint FK_Man_Sender foreign key references Man(FIO), Getter nvarchar(30) constraint FK_Man_Getter foreign key references Man(FIO), Topic nvarchar(20), 
Text_of_letter nvarchar(Max), Date_of_sending date);
insert into Man (FIO, Date_of_birth ) values
('������ �����','2000-05-23'),
('����� ������','2000-04-07'),
('���� ������','2000-02-06');
insert into Letter (ID , Sender , Getter , Topic , 
Text_of_letter , Date_of_sending)  values
(1, '����� ������', '���� ������','a','qwertyuiopasdfghjklzxcvbnm','2019-04-10'),
(2, '������ �����', '���� ������','a','������������������','2019-04-11'),
(3, '������ �����', '����� ������','s','kiuyjhtgrfdvbgnh','2019-04-12'),
(4, '���� ������', '����� ������','n','kjyhgtrfghjuy','2019-04-13'),
(5, '���� ������', '������ �����','r','��������������','2019-04-14');
select * from Man where FIO in (select Getter from Letter where Topic = 's');
select Man.FIO, Man.Date_of_birth from Man inner join Letter on (LEN(Text_of_letter)=(select Min(LEN(Text_of_letter)) from Letter) and Man.FIO=Letter.Sender);
select * ,(select Count(*) from Letter where sender = a.Fio)[���������� ������������],(select Count(*) from Letter where getter = a.Fio)[���������� ��������] from Man as a;