CREATE DATABASE [dbBanHang]
GO
USE [dbBanHang]
GO
/****** Object:  Table [dbo].[chi_tiet_hoa_don]    Script Date: 20/11/2019 12:04:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chi_tiet_hoa_don](
	[mahoadon] [varchar](255) NOT NULL,
	[ma_san_pham] [varchar](255) NOT NULL,
	[don_gia] [float] NOT NULL,
	[so_luong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[mahoadon] ASC,
	[ma_san_pham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[danh_gia]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[danh_gia](
	[id_binh_luan] [varchar](255) NOT NULL,
	[noi_dung] [nvarchar](255) NULL,
	[ma_khach_hang] [varchar](255) NULL,
	[ma_san_pham] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_binh_luan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoa_don]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoa_don](
	[ma_hoa_don] [varchar](255) NOT NULL,
	[ngay_lap] [date] NULL,
	[ma_khach_hang] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_hoa_don] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khach_hang]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khach_hang](
	[ma_khach_hang] [varchar](255) NOT NULL,
	[dia_chi] [nvarchar](255) NULL,
	[email] [varchar](255) NULL,
	[ho_ten_khach_hang] [nvarchar](255) NULL,
	[so_dien_thoai] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_khach_hang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nha_san_xuat]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nha_san_xuat](
	[ma_nha_san_xuat] [varchar](255) NOT NULL,
	[dia_chi] [nvarchar](255) NULL,
	[ten_nha_san_xuat] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_nha_san_xuat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [bigint] NOT NULL,
	[ten] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[san_pham]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[san_pham](
	[ma_san_pham] [varchar](255) NOT NULL,
	[don_gia] [float] NOT NULL,
	[imgurl] [varchar](255) NULL,
	[mo_ta] [nvarchar](255) NULL,
	[nam_san_xuat] [int] NOT NULL,
	[ten_san_pham] [nvarchar](255) NULL,
	[ma_nha_san_xuat] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_san_pham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tai_khoan]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tai_khoan](
	[ma_tai_khoan] [varchar](255) NOT NULL,
	[mat_khau] [varchar](255) NULL,
	[ten_tai_khoan] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_tai_khoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tai_khoan_roles]    Script Date: 20/11/2019 12:04:12 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tai_khoan_roles](
	[taikhoan_ma_tai_khoan] [varchar](255) NOT NULL,
	[roles_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[taikhoan_ma_tai_khoan] ASC,
	[roles_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[chi_tiet_hoa_don] ([mahoadon], [ma_san_pham], [don_gia], [so_luong]) VALUES (N'402809816e7c7fd5016e7c80d1860000', N'SP0010', 85, 1)
INSERT [dbo].[chi_tiet_hoa_don] ([mahoadon], [ma_san_pham], [don_gia], [so_luong]) VALUES (N'402809816e7c7fd5016e7c80d1860000', N'SP003', 85, 1)
INSERT [dbo].[chi_tiet_hoa_don] ([mahoadon], [ma_san_pham], [don_gia], [so_luong]) VALUES (N'4028abcc6e6de484016e6de70f820000', N'SP001', 49, 1)
INSERT [dbo].[chi_tiet_hoa_don] ([mahoadon], [ma_san_pham], [don_gia], [so_luong]) VALUES (N'4028abcc6e6de484016e6de70f820000', N'SP0010', 85, 1)
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'1', N'Đã dùng và cảm thấy rất ngon', N'402809816e6a8326016e6a832f6b0000', N'SP001')
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'2', N'Rất ngon', N'402809816e6a8326016e6a832f6b0000', N'SP002')
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'3', N'Tạm chấp nhận được', N'402809816e6a8326016e6a832f6b0000', N'SP003')
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'4', N'Không ngon', N'402809816e6b1470016e6b15b58c0000', N'SP001')
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'402809816e851693016e85175ca50000', N'dfhddgjnf', N'402809816e6acb45016e6acc6c120000', N'SP001')
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'402809816e851987016e851a0fd20000', N'rtegrbrb', N'402809816e6acb45016e6acc6c120000', N'SP001')
INSERT [dbo].[danh_gia] ([id_binh_luan], [noi_dung], [ma_khach_hang], [ma_san_pham]) VALUES (N'402809816e8534c2016e8535105b0000', N'dở', N'402809816e6acb45016e6acc6c120000', N'SP0010')
INSERT [dbo].[hoa_don] ([ma_hoa_don], [ngay_lap], [ma_khach_hang]) VALUES (N'402809816e7c7fd5016e7c80d1860000', CAST(N'2019-11-18' AS Date), N'402809816e6acb45016e6acc6c120000')
INSERT [dbo].[hoa_don] ([ma_hoa_don], [ngay_lap], [ma_khach_hang]) VALUES (N'4028abcc6e6de484016e6de70f820000', CAST(N'2019-11-15' AS Date), N'402809816e6acb45016e6acc6c120000')
INSERT [dbo].[khach_hang] ([ma_khach_hang], [dia_chi], [email], [ho_ten_khach_hang], [so_dien_thoai]) VALUES (N'402809816e6a8326016e6a832f6b0000', N'A204 CC Thuan Kieu', N'bsrsrng@gmail.com', N'Truong Minh', N'0968369378')
INSERT [dbo].[khach_hang] ([ma_khach_hang], [dia_chi], [email], [ho_ten_khach_hang], [so_dien_thoai]) VALUES (N'402809816e6acb45016e6acc6c120000', N'12 Nguyễn Văn Bảo', N'truongquocminh.it@gmail.com', N'Trương Quốc Minh', N'0968369378')
INSERT [dbo].[khach_hang] ([ma_khach_hang], [dia_chi], [email], [ho_ten_khach_hang], [so_dien_thoai]) VALUES (N'402809816e6b0fad016e6b10c43a0000', NULL, NULL, NULL, NULL)
INSERT [dbo].[khach_hang] ([ma_khach_hang], [dia_chi], [email], [ho_ten_khach_hang], [so_dien_thoai]) VALUES (N'402809816e6b1470016e6b15b58c0000', N'49 Le Loi, p4', N'truongquocminh.it@gmail.com', N'Trần Gia Bảo', N'0987654321')
INSERT [dbo].[nha_san_xuat] ([ma_nha_san_xuat], [dia_chi], [ten_nha_san_xuat]) VALUES (N'01', N'Sandwich', N'HQs Sandwich')
INSERT [dbo].[nha_san_xuat] ([ma_nha_san_xuat], [dia_chi], [ten_nha_san_xuat]) VALUES (N'02', N'Pizza', N'HQs Pizza')
INSERT [dbo].[role] ([id], [ten]) VALUES (1, N'admin')
INSERT [dbo].[role] ([id], [ten]) VALUES (2, N'user')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP001', 49, N'/assets/img/scenery/sub10.png', N'Biggest, Meatest, Tastest với nhiều loại thịt cùng với các loại sốt và rau củ mang nhiều dinh dưỡng và hương vị tuyệt vời', 2018, N'B.M.T', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP0010', 85, N'/assets/img/scenery/sub11.png', N'Ức gà nướng nguyên miếng đầy hấp dẫn giữa nhiều loại rau và sốt', 2018, N'Ức ga', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP002', 85, N'/assets/img/scenery/sub1.jpg', N'Giâm bông và phô mai cùng với rau, sốt phù hợp với mọi lứa tuổi', 2018, N'Ham & Chesse', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP003', 85, N'/assets/img/scenery/sub2.jpg', N'Giâm bông, phô mai và thịt xông khói mang lại hương vị đậm đà kèm rau và sốt', 2018, N'Melt', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP004', 85, N'/assets/img/scenery/sub3.jpg', N'Gà miếng sốt teriyaki mang hương vị khác biệt khi gà được trộn với số teriyaki ăn kèm với một chút rau và sốt', 2018, N'Gà Teriyaki', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP005', 85, N'/assets/img/scenery/sub4.jpg', N'Những miếng gà cắt lát thơm mềm cùng với rau củ và sốt mang lại hương vị tuyệt vời', 2018, N'Gà cắt lát', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP006', 85, N'/assets/img/scenery/sub5.jpg', N'Bò miếng nướng lò mang hương vị đặc trưng nguyên bản của thịt bò tươi', 2018, N'Bò nướng lò', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP007', 85, N'/assets/img/scenery/sub6.jpg', N'Gà turkey theo kiểu Mỹ mang lại hương vị mới lại', 2018, N'Gà Turkey', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP008', 85, N'/assets/img/scenery/sub7.jpg', N'Steak thơm mềm và thấm gia vị mang lại hương vị ngon tuyệt', 2018, N'Bò phô mai', N'01')
INSERT [dbo].[san_pham] ([ma_san_pham], [don_gia], [imgurl], [mo_ta], [nam_san_xuat], [ten_san_pham], [ma_nha_san_xuat]) VALUES (N'SP009', 85, N'/assets/img/scenery/sub8.jpg', N'Bò, Gà, Heo mang lại hương vị đặc sắc', 2018, N'Club mixed', N'01')
INSERT [dbo].[tai_khoan] ([ma_tai_khoan], [mat_khau], [ten_tai_khoan]) VALUES (N'402809816e6a8326016e6a832f6b0000', N'$2a$10$Cs5xZhyRAfTcKOnIFpgh3.Fzs0VDcQkwPx3lGoCXW.PEbUMWaUJC2', N'admin')
INSERT [dbo].[tai_khoan] ([ma_tai_khoan], [mat_khau], [ten_tai_khoan]) VALUES (N'402809816e6acb45016e6acc6c120000', N'$2a$10$UaY7SFU/2WrdX3WeL54M6ew69UTtXbKtpEU5ohz8Bkg0E.yqDn/qe', N'minhlk320')
INSERT [dbo].[tai_khoan] ([ma_tai_khoan], [mat_khau], [ten_tai_khoan]) VALUES (N'402809816e6b0fad016e6b10c43a0000', N'$2a$10$xPQ9EjLa5U8QCXMbLQqfzOZI8NWwvbuwYQ6/Gy9VFGrrZBFPOfbIq', N'baogia')
INSERT [dbo].[tai_khoan] ([ma_tai_khoan], [mat_khau], [ten_tai_khoan]) VALUES (N'402809816e6b1470016e6b15b58c0000', N'$2a$10$S/6lVuCILLMQSPNeRowz/OlsCuU/JxtqxtdL7MaiWoH2dFyColRgO', N'baogia1')
INSERT [dbo].[tai_khoan_roles] ([taikhoan_ma_tai_khoan], [roles_id]) VALUES (N'402809816e6a8326016e6a832f6b0000', 1)
INSERT [dbo].[tai_khoan_roles] ([taikhoan_ma_tai_khoan], [roles_id]) VALUES (N'402809816e6a8326016e6a832f6b0000', 2)
INSERT [dbo].[tai_khoan_roles] ([taikhoan_ma_tai_khoan], [roles_id]) VALUES (N'402809816e6acb45016e6acc6c120000', 2)
INSERT [dbo].[tai_khoan_roles] ([taikhoan_ma_tai_khoan], [roles_id]) VALUES (N'402809816e6b0fad016e6b10c43a0000', 2)
INSERT [dbo].[tai_khoan_roles] ([taikhoan_ma_tai_khoan], [roles_id]) VALUES (N'402809816e6b1470016e6b15b58c0000', 2)
ALTER TABLE [dbo].[chi_tiet_hoa_don]  WITH CHECK ADD  CONSTRAINT [FK2ikmjrcu4osktkq8tguihi13b] FOREIGN KEY([mahoadon])
REFERENCES [dbo].[hoa_don] ([ma_hoa_don])
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] CHECK CONSTRAINT [FK2ikmjrcu4osktkq8tguihi13b]
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don]  WITH CHECK ADD  CONSTRAINT [FK2vqk43lkoa5rm4f7meu8d2cud] FOREIGN KEY([ma_san_pham])
REFERENCES [dbo].[san_pham] ([ma_san_pham])
GO
ALTER TABLE [dbo].[chi_tiet_hoa_don] CHECK CONSTRAINT [FK2vqk43lkoa5rm4f7meu8d2cud]
GO
ALTER TABLE [dbo].[danh_gia]  WITH CHECK ADD  CONSTRAINT [FK3pc5moxhv62c653u456v9i210] FOREIGN KEY([ma_khach_hang])
REFERENCES [dbo].[khach_hang] ([ma_khach_hang])
GO
ALTER TABLE [dbo].[danh_gia] CHECK CONSTRAINT [FK3pc5moxhv62c653u456v9i210]
GO
ALTER TABLE [dbo].[danh_gia]  WITH CHECK ADD  CONSTRAINT [FKpbeq6b9jj7cucgkfxmg82840h] FOREIGN KEY([ma_san_pham])
REFERENCES [dbo].[san_pham] ([ma_san_pham])
GO
ALTER TABLE [dbo].[danh_gia] CHECK CONSTRAINT [FKpbeq6b9jj7cucgkfxmg82840h]
GO
ALTER TABLE [dbo].[hoa_don]  WITH CHECK ADD  CONSTRAINT [FKnuqkgajew2traqcy7umgm7i1g] FOREIGN KEY([ma_khach_hang])
REFERENCES [dbo].[khach_hang] ([ma_khach_hang])
GO
ALTER TABLE [dbo].[hoa_don] CHECK CONSTRAINT [FKnuqkgajew2traqcy7umgm7i1g]
GO
ALTER TABLE [dbo].[san_pham]  WITH CHECK ADD  CONSTRAINT [FKcpd2cfvae7b6pipxrjmsfg04o] FOREIGN KEY([ma_nha_san_xuat])
REFERENCES [dbo].[nha_san_xuat] ([ma_nha_san_xuat])
GO
ALTER TABLE [dbo].[san_pham] CHECK CONSTRAINT [FKcpd2cfvae7b6pipxrjmsfg04o]
GO
ALTER TABLE [dbo].[tai_khoan]  WITH CHECK ADD  CONSTRAINT [FKnfd58h0dw3udg2mg64soys3bw] FOREIGN KEY([ma_tai_khoan])
REFERENCES [dbo].[khach_hang] ([ma_khach_hang])
GO
ALTER TABLE [dbo].[tai_khoan] CHECK CONSTRAINT [FKnfd58h0dw3udg2mg64soys3bw]
GO
ALTER TABLE [dbo].[tai_khoan_roles]  WITH CHECK ADD  CONSTRAINT [FKsa5ffilxhyln5kr0sob2cbop0] FOREIGN KEY([roles_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[tai_khoan_roles] CHECK CONSTRAINT [FKsa5ffilxhyln5kr0sob2cbop0]
GO
ALTER TABLE [dbo].[tai_khoan_roles]  WITH CHECK ADD  CONSTRAINT [FKsytsen0sstfhgd856853r7j2s] FOREIGN KEY([taikhoan_ma_tai_khoan])
REFERENCES [dbo].[tai_khoan] ([ma_tai_khoan])
GO
ALTER TABLE [dbo].[tai_khoan_roles] CHECK CONSTRAINT [FKsytsen0sstfhgd856853r7j2s]
GO
