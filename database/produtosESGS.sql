-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 03-Dez-2019 às 18:33
-- Versão do servidor: 10.1.25-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `products`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `products1`
--

CREATE TABLE `products` (
  `id` bigint(20) NOT NULL,
  `name` varchar(528) COLLATE utf8_bin NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `products1`
--

INSERT INTO `products` (`id`, `name`) VALUES
(1006899027, 'Suspensão Smart PHILIPS HUE Beyond Colours'),
(1006899237, 'Plafon Philips Hue Beyond Colours'),
(1030992840, 'Kit SOMFY TaHoma serenity Essential Video'),
(1030992910, 'Kit Tahoma SOMFY Serenity Essential'),
(1032920984, 'Câmara NETGEAR ARLO Pro Kit 3 + Base'),
(1036353270, 'Kit Segurança SOMFY One + Branco'),
(1055014438, 'Proteção  Câmara de Segurança LEVELONE BOH-1401'),
(1055028689, 'Câmara de segurança LEVELONE FCS-3093'),
(1055028697, 'Kit de vigilância ARLO Pro'),
(1055028700, 'Câmara de segurança NETGEAR ARLO Pro VMS4530'),
(1055028737, 'Kit de segurança ARLO VMS4330P'),
(1055028780, 'Câmara de segurança TRENDNET TV-IP440PI'),
(1055028880, 'Kit de vigilância CONCEPTRONIC C8CCTVKITD6TB'),
(1055028904, 'Câmara de segurança APC NBWL0355A'),
(1055028923, 'Câmara de segurança LEVELONE FCS-3306'),
(1055028927, 'Câmara de segurança LEVELONE FCS-5103'),
(1055028947, 'Câmara de segurança D-LINK DCS-7413'),
(1055028967, 'Câmara de segurança LEVELONE FCS-4203'),
(1055029044, 'Câmara de segurança D-LINK DCS-6517'),
(1055029056, 'Câmara de segurança D-LINK DCS-7517'),
(1055029227, 'Câmara de segurança PANASONIC WV-SPN531A'),
(1055029304, 'Câmara de segurança LEVELONE FCS-5042'),
(1055029355, 'Câmara de segurança LEVELONE FCS-3064'),
(1055029370, 'Câmara de segurança LEVELONE FCS-3083'),
(1055029371, 'Câmara de segurança LEVELONE FCS-3094'),
(1055029378, 'Câmara de segurança SONY SNC-VB600'),
(1055029383, 'Câmara de segurança LEVELONE FCS-4044'),
(1055029385, 'Câmara de segurança LEVELONE FCS-4043'),
(1055029407, 'Câmara de segurança LEVELONE FCS-5057'),
(1055029439, 'Câmara de segurança SONY SNC-EB632R'),
(1055029480, 'Câmara de segurança AXIS P1364'),
(1055029486, 'Câmara de segurança PANASONIC WV-SF438E'),
(1055029487, 'Câmara de segurança AXIS P3367-V'),
(1055029491, 'Câmara de segurança AXIS M3047-P'),
(1055029499, 'Câmara de segurança AXIS P3346-VE'),
(1055029514, 'Câmara de segurança LOGITECH CIRCLE 2'),
(1055029888, 'Câmara de segurança HIKVISION DIGITAL TECHNOLOGY DS-2CD4125FWD-IZ(2.8-12mm)'),
(1055029943, 'Câmara de segurança HIKVISION DIGITAL TECHNOLOGY DS-2CD4B26FWD-IZ(S)'),
(1055030163, 'Kit de vigilância EZVIZ CS-BW2824-B1E10'),
(1055030186, 'Câmara de segurança AXIS P3364-VE 6mm'),
(1055030197, 'Câmara de segurança AXIS M3025-VE'),
(1055030202, 'Câmara de segurança AXIS M3024-LVE'),
(1055030204, 'Câmara de segurança AXIS P1214'),
(1055030210, 'Câmara de segurança AXIS P1214-E'),
(1055030220, 'Câmara de segurança AXIS P5414-E'),
(1055030221, 'Câmara de segurança AXIS M3026-VE'),
(1055030227, 'Câmara de segurança AXIS P5415-E'),
(1055030236, 'Câmara de segurança AXIS P3367-VE'),
(1055030246, 'Câmara de segurança AXIS Q1765-LE'),
(1055030247, 'Câmara de segurança AXIS P1224-E'),
(1055030250, 'Câmara de segurança AXIS M3027-PVE', 1000.65),
(1055030251, 'Câmara de segurança AXIS M1145-L', 1000.68),
(1055030291, 'Câmara de segurança AXIS M1124-E', 1000.02),
(1055030297, 'Câmara de segurança AXIS M1125-E', 560.38),
(1055030301, 'Câmara de segurança AXIS P1367', 1000.22),
(1055030305, 'Câmara de segurança AXIS P1367-E', 1060.47),
(1055030318, 'Câmara de segurança AXIS V5914 50Hz', 1000.2),
(1055030323, 'Câmara de segurança AXIS M3037-PVE', 1000.07),
(1055030335, 'Câmara de segurança AXIS P3707-PE', 1000.51),
(1055030338, 'Câmara de segurança AXIS Q1615-E MK II', 2370.53),
(1055030340, 'Câmara de segurança AXIS A8105-E', 1000.78),
(1055030345, 'Câmara de segurança AXIS P3227-LVE', 1025.28),
(1055030346, 'Câmara de segurança AXIS P3228-LVE', 1000.92),
(1055030348, 'Câmara de segurança AXIS P3228-LV', 1116.48),
(1055030353, 'Câmara de segurança AXIS P1435-LE 22MM', 1000.24),
(1055030354, 'Câmara de segurança AXIS P3227-LV', 1000.02),
(1055030359, 'Câmara de segurança AXIS P1435-LE', 683.11),
(1055030362, 'Câmara de segurança AXIS P1364-E', 1000.35),
(1055030363, 'Câmara de segurança AXIS P1365 Mk II', 742.63),
(1055030372, 'Câmara de segurança AXIS P1365-E Mk II', 1198),
(1055030377, 'Câmara de segurança AXIS P5624-E MK II 50HZ', 1000.71),
(1055030384, 'Câmara de segurança AXIS M3048-P', 763.52),
(1055030392, 'Câmara de segurança AXIS P3224-V Mk II', 477.83),
(1055030393, 'Câmara de segurança AXIS P3225-V Mk II', 1000.72),
(1055030396, 'Câmara de segurança AXIS P3225-VE Mk II', 1000.07),
(1055030397, 'Câmara de segurança AXIS Q6000-E 50Hz Mk II', 2633.43),
(1055030402, 'Câmara de segurança AXIS P3225-LV Mk II', 660.29),
(1055030406, 'Câmara de segurança AXIS P3225-LVE Mk II', 1000.86),
(1055030416, 'Câmara de segurança AXIS P1405-LE Mk II', 1000.58),
(1055030423, 'Câmara de segurança AXIS Q3517-LVE', 1000.15),
(1055030424, 'Câmara de segurança AXIS M3106-L Mk II', 1000.67),
(1055030430, 'Câmara de segurança AXIS Q3515-LV', 969),
(1055030432, 'Câmara de segurança AXIS M3106-LVE Mk II', 1000.51),
(1055030433, 'Câmara de segurança AXIS Q3515-LVE', 1139.5),
(1055030438, 'Câmara de segurança AXIS P3807-PVE', 1539.38),
(1055030442, 'Câmara de segurança AXIS P1447-LE', 961.61),
(1055030443, 'Câmara de segurança AXIS P1448-LE', 1082.99),
(1055030451, 'Câmara de segurança AXIS P3374-LV', 797.15),
(1055030452, 'Câmara de segurança AXIS P3375-V', 1000.29),
(1055030455, 'Câmara de segurança AXIS P3375-LV', 1000.17),
(1055030456, 'Câmara de segurança AXIS P3375-LVE', 1139.44),
(1055030459, 'Câmara de segurança AXIS P3374-V', 898.93),
(1055030464, 'Câmara de segurança AXIS M5054', 568.99),
(1055030466, 'Câmara de segurança AXIS M5055', 683.04),
(1055030473, 'Câmara de segurança AXIS M5525-E', 1000.59),
(1055030477, 'Câmara de segurança AXIS P1368-E', 1000.57),
(1055030483, 'Câmara de segurança AXIS Q1786-LE', 1595.75),
(1055030485, 'Câmara de segurança AXIS Q1785-LE', 2171.06),
(1055030487, 'Câmara de segurança AXIS M3058-PLVE', 968.9),
(1055030492, 'Câmara de segurança AXIS M3057-PLVE', 740.8),
(1055030497, 'Câmara de segurança AXIS P3235-LV', 807.79),
(1055030499, 'Câmara de segurança AXIS P3717-PLE', 1000.39),
(1055030502, 'Câmara de segurança AXIS P1445-LE-3', 1139.36),
(1055030507, 'Câmara de segurança AXIS Q3518-LVE', 1000.85),
(1055030508, 'Câmara de segurança AXIS P1445-LE', 797.17),
(1055030515, 'Câmara de segurança AXIS Q3515-LV', 1000.18),
(1055030524, 'Câmara de segurança AXIS Q3515-LVE', 1197.2),
(1055086048, 'Segurança Portas AXIS A1001', 1000.58),
(1055086061, 'Segurança Portas REINER SCT TimeCard Select Terminal', 1000.59),
(1055086064, 'Segurança Portas REINER SCT TimeCard', 574.08),
(1055094206, 'Intercomunicador de Vídeo Smart Home FIBARO Intercom', 1097.41),
(1055094207, 'Intercomunicador de Vídeo PANASONIC Vl-Swd501', 1000.31),
(1055109834, 'Sistema de Segurança APC NetBotz Rack Monitor 450', 1747.9),
(1055169667, 'Hub smart home LUPUS ELECTRONICS Xt2 Plus Zentrale', 1000.89),
(1055174135, 'Kit de Videovigilância TECHNAXX Maxi Security Kit PRO', 1000.77),
(1055174192, 'Câmara de Segurança AXIS V5915 50Hz', 1000.69),
(1055174238, 'Câmara de Segurança D-LINK DCS-6517', 1000.15),
(1055174241, 'Câmara de Segurança UBIQUITI NETWORKS UniFi G3 Dome', 1000.63),
(1055174256, 'Gravador AXIS Companion Recorder', 683.29),
(1055174260, 'Gravador AXIS COMPANION REC 8CH 2TB', 569.22),
(1055174263, 'Câmara de Segurança AXIS P5635-E MK II 50HZ', 1000.12),
(1055174269, 'Câmara de Segurança AXIS Q3708-PVE', 1000.22),
(1055174287, 'Kit de Videovigilância TECHNAXX Premium TX-30', 463.53),
(1055174332, 'Câmara de Segurança AXIS Q1647-LE', 1000.53),
(1055174348, 'Kit de Videovigilância NETGEAR VMS4430P', 1000.08),
(1055174352, 'Câmara de Segurança AXIS M3046-V', 1000.8),
(1055174358, 'Câmara de Segurança SONY SRG-120DU', 2360.93),
(1055174359, 'Câmara de Segurança AXIS Q6125-LE', 3420.78),
(1055174367, 'Kit de Videovigilância NETGEAR VMS4230P', 537.19),
(1055174369, 'Kit Câmara WiFi D-Link Pro DCS-2802KT', 1000.05),
(1055219758, 'Intercomunicador 2N TELECOMMUNICATIONS 9155101C', 1000.72),
(1055242649, 'Kit de videovigilância D-LINK DNR16-4802-2', 1000.2),
(1055242653, 'Sistema de áudio e vídeo AUERSWALD TFS-Dialog 400 em Azul', 510.26),
(1055249957, 'Sensor APC NetBotz Particle Sensor PS100', 1000.79),
(1055250491, 'Servidor AXIS F41', 484.75),
(1055250492, 'Módulo câmara segurança AXIS F44', 626.71),
(1059216287, 'Vídeo porteiro DOORBIRD D101', 1000.1),
(1059216306, 'Vídeo porteiro DOORBIRD D101S', 1000.05),
(1059231595, 'Câmara de videoconferência AVERMEDIA VC520+ Preto', 1000.14),
(1059231605, 'Câmara de videoconferência AVERMEDIA CAM340 Preto', 1000.15),
(1059231651, 'Servidor de vigilância em rede SYNOLOGY VS960HD', 681.75),
(1059231654, 'Servidor de vigilância em rede QNAP VS-2108L', 553.1),
(1059231752, 'Câmara de segurança SONY SRG-300HW Branco', 2873.27),
(1059231888, 'Servidor AXIS 0778-001', 1000.82),
(1059231940, 'Câmara de segurança AXIS 0909-002 Branco', 4431.08),
(1059231958, 'Kit de videovigilância SMARTWARES 10.037.77', 1000.67),
(1059232031, 'Câmara de segurança AXIS 0808-001 Branco', 1000.69),
(1059232183, 'Câmara de segurança LEVELONE FCS-3304 Branco', 1000.07),
(1059232225, 'Câmara de segurança AXIS 01078-001 Branco', 1000.12),
(1059232234, 'Câmara de segurança LEVELONE FCS-4051 Preto Branco', 706.38),
(1059232259, 'Câmara de segurança LEVELONE FCS-3307 Branco', 726.73),
(1059232271, 'Câmara de segurança RING Ring spotlight Preto Branco', 1000.8),
(1059232299, 'Câmara de segurança AXIS 01222-001 Preto Prateado', 1000.69),
(1059232543, 'Câmara de segurança AXIS 01199-001 Branco', 1000.94),
(1059232672, 'Câmara de segurança LEVELONE FCS-5096 Branco', 1000.55),
(1059298669, 'Câmara de segurança KÖNIG SEC-CAM901', 995.86),
(1059298754, 'Câmara de segurança AXIS P1365-E Mk II', 1430.65),
(1059298771, 'Kit de segurança AXIS P1244', 1000.39),
(1059298856, 'Kit de videovigilância SMARTWARES WDVR740S', 1000.75),
(1059314154, 'Hub smart home FIBARO Fibaro Home Center 2', 1000.69),
(1060785452, 'Acessório câmara de segurança AXIS 5507-491', 573.65),
(1060785485, 'Acessório câmara de segurança AXIS 01210-001', 1000.96),
(1060785554, 'Acessório câmara de segurança AXIS T98A16-VE', 506.99),
(1060785988, 'Acessório câmara de segurança AXIS T98A17-VE', 1001),
(1060786004, 'Acessório câmara de segurança AXIS T98A15-VE', 1000.48),
(1060857441, 'Câmara de segurança D-LINK DCS-7513', 1000.09),
(1060857450, 'Câmara de segurança AXIS M3026-VE', 1000.38),
(1060857468, 'Câmara de segurança D-LINK DCS-6517', 828.99),
(1060857476, 'Câmara de segurança AXIS Q1941-E', 1000.89),
(1060857477, 'Câmara de segurança D-LINK DCS-7517', 986.99),
(1060857504, 'Câmara de segurança HIKVISION DIGITAL TECHNOLOGY DS-2CD4A26FWD-IZS/P', 1000.23),
(1060857546, 'Câmara de segurança LEVELONE FCS-5102', 1000.5),
(1060857581, 'Kit de videoconferência AVERMEDIA VC322', 1000.5),
(1060857640, 'Câmara de segurança AXIS M5065 PTZ', 897.91),
(1060857693, 'Kit de videovigilância NEDIS AHDS204CWT4', 459.2),
(1060887583, 'Kit instalação AXIS T8415 Wireless', 1000.84),
(1060947447, 'Lâmpada inteligente PHILIPS BY SIGNIFY branco e cor Signe chão 40802/48/P7', 2423.93),
(1060954708, 'Sensor ambiental para smarthome GARDENA 19102-20', 1000.15),
(1060965257, 'Kit de videovigilância CCTV exterior CONCEPTRONIC C8CCTVKITD10806TB', 592.99),
(1060965281, 'Câmara IP interior AXIS P9106-V', 1098.94),
(1060965319, 'Kit IP interior e exterior ANKER eufyCam', 1000.54),
(1060965352, 'Câmara IP interior AXIS M4206-LV', 605.1),
(1060965356, 'Vídeoporteiro AXIS A8207-VE', 1000.86),
(1061083994, 'Gravador de vídeo em rede (NVR) QNAP VS-2204 PRO+', 1144.95),
(1061084002, 'Gravador de vídeo em rede (NVR) LEVELONE NVR-1216', 1000.5),
(1061676509, 'Câmara de segurança IP AXIS M1125-E', 1000.09),
(1061676669, 'Central smarthome LUPUS ELECTRONICS XT2 Zentrale', 1000.12),
(1061676750, 'Kit de videovigilância YALE SV-4C-2DB4MX', 1000.5),
(1061676961, 'Kit de videovigilância SMARTWARES WDVR840S', 1000.41),
(1061677103, 'Câmara de segurança IP AXIS Q6045-C MK II', 4932.67),
(1061677120, 'Kit de videovigilância SMARTWARES DVR728S', 1000.9),
(1061869230, 'Sistema de áudio e videoporteiro GIRA 250120', 506.98),
(1061869274, 'Sistema de áudio e videoporteiro RITTO 1841270', 540.03),
(1061869441, 'Sistema de alarme KENTIX KSS-PRO-1-B', 970.74),
(1062051302, 'Câmara de segurança IP exterior HANWHA XNV-6020R', 648.55),
(1062051329, 'Câmara de segurança IP exterior HANWHA XNO-6080R', 1132.14),
(1062051359, 'Câmara de segurança IP exterior AXIS Q1941-E', 2273.63),
(1062051370, 'Câmara de segurança IP exterior AXIS Q6155-E 50 Hz', 1000.35),
(1062051374, 'Câmara de segurança IP interior AXIS Q8414-LVS', 2416.55),
(1062051400, 'Câmara de segurança IP exterior AXIS Q1941-E', 1000.35),
(1062051418, 'Câmara de segurança IP interior e exterior LUPUS ELECTRONICS LUPUSNET HD - LE936 Plus PoE', 1000.18),
(1062051445, 'Câmara de segurança IP interior AXIS Q6054 Mk III', 1000.4),
(1062051453, 'Câmara de videoconferência SONY SRG-360SHE', 1000.94),
(1062051465, 'Servidor APC NetBotz 125kHz Rack Access Control', 1000.2),
(1062051468, 'Câmara de vigilância ARLO Ultra VMS5140', 580),
(1062051485, 'Câmara de segurança IP interior e exterior AXIS Q6124-E 50HZ PTZ', 1000.35),
(1062285510, 'Câmara de videoconferência SONY SRG-120DH', 2866.35),
(1062285547, 'Câmara de segurança IP AXIS M4206-V', 477.74),
(1062285587, 'Monitor de vigilância AG NEOVO SC-42AH', 1007.99),
(1062285595, 'Câmara de segurança IP HIKVISION DIGITAL TECHNOLOGY DS-2CD2785FWD-IZS', 1000.39),
(1062285607, 'Pack 4 Câmaras de segurança ARLO Ultra VMS5440', 1000.35),
(1062285609, 'Câmara de segurança IP ARLO VMS5340', 1162.97),
(1062285621, 'Pack 2 Câmaras de segurança NETGEAR ARLO Ultra VMS5240', 1000.76),
(1062305418, 'Sensor de temperatura e humidade KENTIX KMS-LAN', 534.29),
(1062305423, 'Sensor de temperatura e humidade KENTIX MultiSensor-LAN-RF', 1000.49),
(1062305436, 'Sensor de temperatura e humidade KENTIX MultiSensor-LAN', 1000.13),
(1062305454, 'Sistema de alarme de segurança KENTIX KSS-BASIC-1-B', 1000.11),
(1062305863, 'Acessório para intercomunicador GIRA 128603', 763.36),
(1062333335, 'Intercomunicador de vídeo DOORBIRD D2102V', 1074.07),
(1062333339, 'Intercomunicador de vídeo DOORBIRD D202', 648.92),
(1062333345, 'Intercomunicador de vídeo M-E VDV-910', 590.38),
(1062333388, 'Intercomunicador de vídeo M-E VD-6720', 1000.32),
(1062333412, 'Intercomunicador de vídeo SMARTWARES DIC-22222', 457.24),
(1062333419, 'Intercomunicador de vídeo DOORBIRD D2103V', 1143.82),
(1062333425, 'Intercomunicador de vídeo DOORBIRD D2101V', 1000.58),
(1062333498, 'Intercomunicador de vídeo BUSCH-JAEGER 8300-0-0004', 1000.5),
(1062333596, 'Atuador inteligente para persianas e estores BUSCH-JAEGER 6151-0-0221', 1000.4),
(1062551016, 'Câmara de segurança IP D-LINK DCS-7513/E 1920 x 1080 pixels', 1000.09),
(1064441057, 'Câmara de segurança IP HANWHA XNO-6020R Exterior FHD', 1000.09),
(1064441302, 'Câmara de segurança IP HANWHA XNO-6010R Exterior FHD', 1000.85),
(1064703498, 'Câmara de vigilância AXIS P1375-E FHD', 1221.64),
(1064703505, 'Monitor AG NEOVO RX-32E FHD', 1000.13),
(1064703518, 'Câmara de vigilância CANON VB-M640VE 480p', 878.63),
(1064703523, 'Câmara de vigilância AXIS P5655-E 50HZ  FHD', 1000.29),
(1064943279, 'Salicru SENSOR T+H GX', 544);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `products1`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);
COMMIT;
--
-- Índices para tabela `products2`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
