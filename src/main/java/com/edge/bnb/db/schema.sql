DROP TABLE IF EXISTS address
GO

DROP TABLE IF EXISTS contact
GO

DROP TABLE IF EXISTS hotel
GO

CREATE TABLE [dbo].[hotel]
(
    [id] UNIQUEIDENTIFIER NOT NULL,
    [description] [varchar](255) NULL,
    [name] [varchar](255) NULL
)
GO

ALTER TABLE [dbo].[hotel] ADD PRIMARY KEY CLUSTERED (id ASC)
GO

CREATE TABLE [dbo].[contact]
(
    [id] UNIQUEIDENTIFIER NOT NULL,
    [first_name] [varchar](255) NULL,
    [image_url] [varchar](255) NULL,
    [last_name] [varchar](255) NULL,
    [type_code] [varchar](255) NULL,
    [hotel_id] UNIQUEIDENTIFIER NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[contact] ADD PRIMARY KEY CLUSTERED (	[id] ASC)
GO

ALTER TABLE [dbo].[contact]  WITH NOCHECK ADD  CONSTRAINT [FK_contact_hotel] FOREIGN KEY([hotel_id])
REFERENCES [dbo].[hotel] ([id])
GO

ALTER TABLE [dbo].[contact] NOCHECK CONSTRAINT [FK_contact_hotel]
GO

CREATE TABLE [dbo].[address]
(
    [id] UNIQUEIDENTIFIER NOT NULL,
    [city] [varchar](255) NULL,
    [country] [varchar](255) NULL,
    [line_one] [varchar](255) NULL,
    [line_two] [varchar](255) NULL,
    [type_code] [varchar](255) NULL,
    [contact_id] UNIQUEIDENTIFIER NULL
)
GO

ALTER TABLE [dbo].[address] ADD PRIMARY KEY CLUSTERED
(
	[id] ASC
)
GO

ALTER TABLE [dbo].[address]  WITH NOCHECK ADD  CONSTRAINT [FK_address_contact] FOREIGN KEY([contact_id])
REFERENCES [dbo].[contact] ([id])
GO

ALTER TABLE [dbo].[address] NOCHECK CONSTRAINT [FK_address_contact]
GO
