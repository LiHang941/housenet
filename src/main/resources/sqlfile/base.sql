/*
Navicat SQL Server Data Transfer

Source Server         : sqlserver
Source Server Version : 105000
Source Host           : localhost:1433
Source Database       : housenet
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 105000
File Encoding         : 65001

Date: 2017-11-01 17:27:39
*/


-- ----------------------------
-- Table structure for district
-- ----------------------------
DROP TABLE [dbo].[district]
GO
CREATE TABLE [dbo].[district] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] varchar(50) NOT NULL 
)


GO

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE [dbo].[house]
GO
CREATE TABLE [dbo].[house] (
[id] int NOT NULL IDENTITY(1,1) ,
[user_id] int NULL ,
[type_id] int NULL ,
[title] nvarchar(50) NULL ,
[description] nvarchar(2000) NULL ,
[price] int NULL ,
[pubdate] date NULL ,
[floorage] int NULL ,
[contact] varchar(100) NULL ,
[street_id] int NULL 
)


GO

-- ----------------------------
-- Table structure for street
-- ----------------------------
DROP TABLE [dbo].[street]
GO
CREATE TABLE [dbo].[street] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] varchar(50) NULL ,
[district_id] int NULL 
)


GO

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE [dbo].[type]
GO
CREATE TABLE [dbo].[type] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] varchar(10) NOT NULL 
)


GO

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE [dbo].[users]
GO
CREATE TABLE [dbo].[users] (
[id] int NOT NULL IDENTITY(1,1) ,
[name] varchar(50) NULL ,
[password] varchar(50) NULL ,
[telephone] varchar(15) NULL ,
[username] varchar(50) NULL ,
[isadmin] varchar(5) NULL 
)


GO

-- ----------------------------
-- Indexes structure for table district
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table district
-- ----------------------------
ALTER TABLE [dbo].[district] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table house
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table house
-- ----------------------------
ALTER TABLE [dbo].[house] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table street
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table street
-- ----------------------------
ALTER TABLE [dbo].[street] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table type
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table type
-- ----------------------------
ALTER TABLE [dbo].[type] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table users
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [dbo].[users] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Foreign Key structure for table [dbo].[house]
-- ----------------------------
ALTER TABLE [dbo].[house] ADD FOREIGN KEY ([street_id]) REFERENCES [dbo].[street] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [dbo].[house] ADD FOREIGN KEY ([type_id]) REFERENCES [dbo].[type] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE [dbo].[house] ADD FOREIGN KEY ([user_id]) REFERENCES [dbo].[users] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

-- ----------------------------
-- Foreign Key structure for table [dbo].[street]
-- ----------------------------
ALTER TABLE [dbo].[street] ADD FOREIGN KEY ([district_id]) REFERENCES [dbo].[district] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
