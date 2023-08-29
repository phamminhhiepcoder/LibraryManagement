USE [master]
GO
/****** Object:  Database [library_management]    Script Date: 8/29/2023 10:15:22 PM ******/
CREATE DATABASE [library_management]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'library_management', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\library_management.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'library_management_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\library_management_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [library_management] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [library_management].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [library_management] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [library_management] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [library_management] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [library_management] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [library_management] SET ARITHABORT OFF 
GO
ALTER DATABASE [library_management] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [library_management] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [library_management] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [library_management] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [library_management] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [library_management] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [library_management] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [library_management] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [library_management] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [library_management] SET  ENABLE_BROKER 
GO
ALTER DATABASE [library_management] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [library_management] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [library_management] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [library_management] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [library_management] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [library_management] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [library_management] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [library_management] SET RECOVERY FULL 
GO
ALTER DATABASE [library_management] SET  MULTI_USER 
GO
ALTER DATABASE [library_management] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [library_management] SET DB_CHAINING OFF 
GO
ALTER DATABASE [library_management] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [library_management] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [library_management] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [library_management] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'library_management', N'ON'
GO
ALTER DATABASE [library_management] SET QUERY_STORE = ON
GO
ALTER DATABASE [library_management] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [library_management]
GO
/****** Object:  Table [dbo].[book]    Script Date: 8/29/2023 10:15:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ISBN] [varchar](255) NULL,
	[author_name] [varchar](255) NULL,
	[category] [varchar](255) NULL,
	[created_date] [datetime2](7) NOT NULL,
	[language] [varchar](255) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[updated_date] [datetime2](7) NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 8/29/2023 10:15:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NOT NULL,
	[email] [varchar](255) NULL,
	[gender] [nvarchar](10) NOT NULL,
	[phone] [varchar](255) NULL,
	[updated_date] [datetime2](7) NOT NULL,
	[address] [varchar](255) NULL,
	[full_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[invoice]    Script Date: 8/29/2023 10:15:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[invoice](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NOT NULL,
	[updated_date] [datetime2](7) NOT NULL,
	[customer_id] [int] NOT NULL,
	[amount] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[invoice_books]    Script Date: 8/29/2023 10:15:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[invoice_books](
	[invoice_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[invoice_id] ASC,
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 8/29/2023 10:15:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NOT NULL,
	[name] [varchar](255) NULL,
	[updated_date] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 8/29/2023 10:15:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime2](7) NOT NULL,
	[email] [varchar](255) NULL,
	[gender] [nvarchar](10) NOT NULL,
	[password] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[updated_date] [datetime2](7) NOT NULL,
	[username] [varchar](255) NULL,
	[role_id] [int] NOT NULL,
	[address] [varchar](255) NULL,
	[full_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[invoice]  WITH CHECK ADD  CONSTRAINT [FK5e32ukwo9uknwhylogvta4po6] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customer] ([id])
GO
ALTER TABLE [dbo].[invoice] CHECK CONSTRAINT [FK5e32ukwo9uknwhylogvta4po6]
GO
ALTER TABLE [dbo].[invoice_books]  WITH CHECK ADD  CONSTRAINT [FK6sb42541bs27gj0qfdm1ps2ou] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([id])
GO
ALTER TABLE [dbo].[invoice_books] CHECK CONSTRAINT [FK6sb42541bs27gj0qfdm1ps2ou]
GO
ALTER TABLE [dbo].[invoice_books]  WITH CHECK ADD  CONSTRAINT [FKdmopmvaqjociwr5ca0ae7vdw5] FOREIGN KEY([invoice_id])
REFERENCES [dbo].[invoice] ([id])
GO
ALTER TABLE [dbo].[invoice_books] CHECK CONSTRAINT [FKdmopmvaqjociwr5ca0ae7vdw5]
GO
ALTER TABLE [dbo].[users]  WITH CHECK ADD  CONSTRAINT [FK4qu1gr772nnf6ve5af002rwya] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([id])
GO
ALTER TABLE [dbo].[users] CHECK CONSTRAINT [FK4qu1gr772nnf6ve5af002rwya]
GO
USE [master]
GO
ALTER DATABASE [library_management] SET  READ_WRITE 
GO
