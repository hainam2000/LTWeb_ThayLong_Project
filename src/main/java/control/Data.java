package control;
import view.*;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public static final String CPU = "CPU";
    public static final String MB = "Mainboard";
    public static final String SSD = "SSD";
    public static final String HDD = "HDD";
    public static final String VGA = "VGA";
    public static final String RAM = "RAM";
    public static Map<String, Product> dataCPU = new HashMap<>();
    static {
        dataCPU.put("01", new Product("01","AMD Athlon™ 200GE 3.2GHz  2 nhân 4 luồng  Radeon™ Vega 3 Graphics",CPU,CPU,"AMDAthlon200GE3.2GHz24RadeonVega3Graphics/gearvn_cpu_amd.jpg", 1460000, 00));
        dataCPU.put("02", new Product("02","AMD Ryzen 3 2200G 3.5 GHz tích hợp VGA Radeon Vega 86MB4 nhân 4 luồng",CPU,CPU,"AMDRyzen32200G3.5GHzVGARadeonVega86MB44/gearvn_amd_ryzen_3_2200g_3.jpg", 01, 01));
        dataCPU.put("03", new Product("03","AMD Ryzen 3 3100 16MB 3.6GHz 4 nhân 8 luồng",CPU,CPU,"AMDRyzen3310016MB3.6GHz48/amd-ryzen-3-3100_b17cab22e8964140b7883479a7e49c69.png", 01, 01));
        dataCPU.put("04", new Product("04","AMD Ryzen 3 3200G 6MB 3.6GHz 4 nhân 4 luồng",CPU,CPU,"AMDRyzen3310016MB3.6GHz48/amd-ryzen-3-3100_b17cab22e8964140b7883479a7e49c69.png", 01, 01));
        dataCPU.put("05", new Product("05","AMD Ryzen 3 3300X 16MB 3.8GHz 4 nhân 8 luồng",CPU,CPU,"AMDRyzen33300X16MB3.8GHz48/amd-ryzen-3-3100_40c54ff2c14f4561ba2ccc226107a9fd.png", 01, 01));
        dataCPU.put("06", new Product("06","AMD Ryzen 5 2400G 3.6 GHz tích hợp VGA Radeon Vega 116MB 4 nhân 8 luồng",CPU,CPU,"AMDRyzen33300X16MB3.8GHz48/amd-ryzen-3-3100_40c54ff2c14f4561ba2ccc226107a9fd.png", 01, 01));
        dataCPU.put("07", new Product("07","AMD Ryzen 5 3400G 6MB 3.7GHz 4 nhân 8 luồng",CPU,CPU,"AMDRyzen53400G6MB3.7GHz48/19250429-a_2ndgen_ryzen5_radeon_spire_lf_9b6f7158122449be826a7de74844ba0e.png", 01, 01));
        dataCPU.put("08", new Product("08","AMD Ryzen 5 3500x 32MB 3.6GHz 6 nhân 6 luồng",CPU,CPU,"AMDRyzen53500x32MB3.6GHz66/rdgen_ryzen5_stealth_3d_row_bf_c9d40185a9004f6e84b9478234af1875_grande_d0d92d1e111f45dc9a1d201820afd389.png", 01, 01));
        dataCPU.put("09", new Product("09","AMD Ryzen 5 3600 36MB 3.6GHz 6 nhân 12 luồng",CPU,CPU,"AMDRyzen5360036MB3.6GHz612/19257929-a_3rdgen_ryzen5_stealth_3d_row_bf_e85a79f242964714b257e64eeb3931c3.png", 01, 01));
        dataCPU.put("10", new Product("10","AMD Ryzen 5 3600x 36MB 3.8GHz 6 nhân 12 luồng",CPU,CPU,"AMDRyzen53600x36MB3.8GHz612/19257929-a_3rdgen_ryzen5_stealth_3d_row_bf_c9d40185a9004f6e84b9478234af1875.png", 01, 01));
        dataCPU.put("11", new Product("11","AMD Ryzen 7 3700x 36MB 3.6GHz 8 nhân 16 luồng",CPU,CPU,"AMDRyzen73700x36MB3.6GHz816/19239708-a_3rdgenryzen7_row_back_e9298b7cb566479c88d145a872907ecc.png", 01, 01));
        dataCPU.put("12", new Product("12","AMD Ryzen 7 3800x 36MB 3.9GHz 8 nhân 16 luồng",CPU,CPU,"AMDRyzen73800x36MB3.9GHz816/19239708-a_3rdgenryzen7_row_lft_34e6a551fba24c418db7dcdf0eb82d92.png", 01, 01));
        dataCPU.put("13", new Product("13","AMD Ryzen 7 5800X  32MB  3.8GHz Boost 4.7GHz  8 nhân 16 luồng",CPU,CPU,"AMDRyzen75800X32MB3.8GHzBoost4.7GHz816/rvn-cpu-amd-ryzen-7-5800x-32mb-3-8ghz-boost-4-7ghz-8-nhan-16-luong-666_675f75aeff4149f1bd15189673faf87e.png", 01, 01));
        dataCPU.put("14", new Product("14","AMD Ryzen 9 3900x 70MB 3.8GHz 12 nhân 24 luồng",CPU,CPU,"AMDRyzen95900X64MB3.7GHzBoost4.8GHz1224/gearvn-amd-ryzen-9-5900x-64mb-3-7ghz-boost-4-8ghz-12-nhan-24-luong-666_c768e9d619a0477ca7433bd76ffc073c.png", 01, 01));
        dataCPU.put("15", new Product("15","AMD Ryzen 9 5900X  64MB  3.7GHz Boost 4.8GHz  12 nhân 24 luồng",CPU,CPU,"AMDRyzen95900X64MB3.7GHzBoost4.8GHz1224/gearvn-amd-ryzen-9-5900x-64mb-3-7ghz-boost-4-8ghz-12-nhan-24-luong_37c9b8b6804944f7ada5d5630bd57537.png", 01, 01));
    }

    public static Map<String, Product> dataMB = new HashMap<>();
    static {
        dataMB.put("01", new Product("01","Asrock B365M Phantom Gaming 4 LGA 1151v2",MB,MB,"AsrockB365MPhantomGaming4LGA1151v2/b365m_phantom_gaming_4_l1__8b87c77d9acd48939a76a93948016018.png",0,0));
        dataMB.put("02", new Product("02","Asrock B365M Pro4 LGA 1151v2",MB,MB,"AsrockB365MPro4LGA1151v2/b365m_pro4_l1__master_ad86450a972345e68fc36ec8204f9d9e.png",0,0));
        dataMB.put("03", new Product("03","Asrock B450M Steel Legend (AMD Socket AM4)",MB,MB,"AsrockB450MSteelLegend(AMDSocketAM4)/81ye8wi3b3l._sl1500_.jpg",0,0));
        dataMB.put("04", new Product("04","ASROCK B460M Pro4",MB,MB,"ASROCKB460MPro4/asrock-b460m-pro4-1_8fdf5873f91441a69637526900b3d69f.png",0,0));
        dataMB.put("05", new Product("05","ASROCK B460M Steel Legend",MB,MB,"ASROCKB460MSteelLegend/b460m-steel-legend-1_8175d16bf3e74ea1b7ab0e031a76ed44.png",0,0));
        dataMB.put("06", new Product("06","ASROCK B550M Pro4",MB,MB,"ASROCKB550MPro4/b550m-pro4-1_e43c4551b91042b4af879b4011451597.png",0,0));
        dataMB.put("07", new Product("07","Asrock H310CM DVS LGA 1151v2",MB,MB,"AsrockH310CMDVSLGA1151v2/h310cm-dvs_gearvn.png",0,0));
        dataMB.put("08", new Product("08","Asrock H310CM HDV LGA 1151v2",MB,MB,"AsrockH310CMHDVLGA1151v2/h310cm-hdv_l1__7655a04ac8e9458ba20b3a1f7e7be4e1.png",0,0));
        dataMB.put("09", new Product("09","ASROCK H310CM HDVM2",MB,MB,"ASROCKH310CMHDVM2/h310cm-hdvm.2_l1__7f3c822956ba4b2683788eebc3cab976.png",0,0));
        dataMB.put("10", new Product("10","ASROCK H410M-HDV",MB,MB,"ASROCKH410M-HDV/h410m-hdv-1_6782b5a5af864a30ad781bc1b4534185.png",0,0));
        dataMB.put("11", new Product("11","ASROCK H410M-HDVM",MB,MB,"ASROCKH410M-HDVM.2/h410m-hdvm.2-1_57ef42ee1c854dd6a1675e6f9793fba5.png",0,0));
        dataMB.put("12", new Product("12","ASROCK H410M-HVS",MB,MB,"ASROCKH410M-HVS/h410m-hvs-1_23684943c2a849bf9a8767f9bd3c8773.png",0,0));
        dataMB.put("13", new Product("13","ASROCK Z390 PRO4 LGA1151V2",MB,MB,"ASROCKZ390PRO4LGA1151V2/z390_pro4_gearvn.jpg",0,0));
        dataMB.put("14", new Product("14","Asus B360G ROG STRIX Gaming LGA 1151v2",MB,MB,"AsusB360GROGSTRIXGamingLGA1151v2/asus_b360g_gearvn00.jpg",0,0));
        dataMB.put("15", new Product("15","Asus B365G ROG STRIX Gaming LGA 1151v2",MB,MB,"AsusB365GROGSTRIXGamingLGA1151v2/2_8edba777bdc847ddaaa8cf71c9a96038.jpg",0,0));
        dataMB.put("16", new Product("16","Asus PRIME H310M-CS R2.0 LGA1151v2",MB,MB,"AsusPRIMEH310M-CSR2.0LGA1151v2/1_c41accee9c424cd693826759b5ad2349.jpg",0,0));
    }

    public static Map<String, Product> dataSSD = new HashMap<>();
    static {
        dataSSD.put("01", new Product("01", "Gigabyte SSD AORUS RGB M.2 NVMe 256GB", SSD,SSD, "GigabyteSSDAORUSRGBM.2NVMe256GB/2019010216293310_src_9aac2c52bdca4d4a9817c79c5a83ad2c.png", 0,0));
        dataSSD.put("02", new Product("02", "Gigabyte SSD AORUS RGB M.2 NVMe 512GB", SSD,SSD, "GigabyteSSDAORUSRGBM.2NVMe512GB/aorus_rgb_ssd_gearvn01_3e4f777d02cf4a129f98e2533e4bda22.png",0,0));
        dataSSD.put("03", new Product("03", "Gigabyte SSD 240GB 2.5\" Sata 3 ( GP-GSTFS31240GNTD )", SSD,SSD, "GigabyteSSD240GB2.5Sata3(GP-GSTFS31240GNTD)/ssd_240gb_gigabyte_gearvn00.jpg",0,0));
        dataSSD.put("04", new Product("04", "HyperX SSD Fury RGB 240GB 2.5\" Sata 3", SSD,SSD, "HyperXSSDFuryRGB240GB2.5Sata3/hx-product-ssd-fury-rgb-3-zm-lg.jpg",0,0));
        dataSSD.put("05", new Product("05", "Intel Optane Memory 16GB - M.2 2280 NVMe Read 900MBs Write 145MBs", SSD,SSD, "IntelOptaneMemory16GB-M.22280NVMeRead900MBsWrite145MBs/intel-optane-gearvn_00.jpg",0,0));
        dataSSD.put("06", new Product("06", "Intel® SSD 660p QLC 512GB M.2 NVMe", SSD,SSD, "IntelSSD660pQLC512GBM.2NVMe/11_a25267a5acbd4c39a3e97bd3d662cff0.png",0,0));
        dataSSD.put("07", new Product("07", "PNY SSD CS900 120G 2.5\" Sata 3", SSD,SSD, "PNYSSDCS900120G2.5Sata3/pny-ssd-cs900-la_0c11edd0a40940d9804af81981a5ab91.png",0,0));
        dataSSD.put("08", new Product("08", "PNY SSD CS900 240G 2.5\" Sata 3", SSD,SSD, "PNYSSDCS900240G2.5Sata3/pny-ssd-cs900-la.png",0,0));
        dataSSD.put("09", new Product("09", "SSD Adata SU650 240Gb SATA3 2.5inch", SSD,SSD, "SSDAdataSU650240GbSATA32.5inch/ssd-adata-su650-120gb-sata3-2-5inch-1_3d7c9a9724c4499da3e98d8feed2514e.jpg",0,0));
        dataSSD.put("10", new Product("10", "SSD ADATA XPG SPECTRIX S40G RGB 256GB", SSD,SSD, "SSDADATAXPGSPECTRIXS40GRGB256GB/_1099535_1a8d8193cbb04475910c3d720824390d.jpg",0,0));
        dataSSD.put("11", new Product("11", "SSD ADATA XPG SPECTRIX S40G RGB 512GB", SSD,SSD, "SSDADATAXPGSPECTRIXS40GRGB512GB/ssd_adata_s40g_gearvn00_9c96b977c6cf4a8ca511b1eb5775fa33.jpg",0,0));
        dataSSD.put("12", new Product("12", "SSD APACER AS450 Panther 2.5 Sata III 120Gb", SSD,SSD, "SSDAPACERAS450Panther2.5SataIII120Gb/gvn_ssd_as450_apacer_d94413e5985a4a0b8cf8eec232f06e6b.jpg",0,0));
        dataSSD.put("13", new Product("13", "Ổ cứng di động SSD Sandisk Extreme Portable 250GB", SSD,SSD, "OcungdidongSSDSandiskExtremePortable250GB/gearvn-o-cung-di-dong-ssd-portable-sandisk-extreme-1_e056116eee59436c927271fa6fa661a8_grande.jpg",0,0));
        dataSSD.put("14", new Product("14", "Ổ cứng di động SSD WD My Passport 500GB USB 3.2 Gen 2", SSD,SSD, "OcungdidongSSDWDMyPassport500GBUSB3.2Gen2/di-do-ng-ssd-wd-my-passport-500gb-usb-3-2-gen-2-wdbagf5000abl-wesn-666_f550c60edd7e422d80c7fefbfb31b85b.png",0,0));
        dataSSD.put("15", new Product("15", "Ổ cứng SSD Intel SSD D3-S4510 240GB", SSD,SSD, "OcungSSDIntelSSDD3-S4510240GB/gearvn-o-cung-hdd-seagate-firecuda-2tb-66_5f789cbc3c6d429cb71127b233d3069b.png",0,0));
        dataSSD.put("16", new Product("16", "Ổ cứng SSD Intel 760P M.2 NVMe 256GB", SSD,SSD, "OcungSSDIntel760PM.2NVMe256GB/gearvn-o-cung-ssd-intel-760p-m-2-nvme-256g-2_1ed1e8977476446e91eeb2964e3b44ac.jpg",0,0));
        dataSSD.put("17", new Product("17", "Ổ cứng SSD Kingston KC2500 2TB PCIe Gen 3.0", SSD,SSD, "OcungSSDKingstonKC25002TBPCIeGen3.0/gearvn-o-cung-ssd-kingston-kc2500-1_2e6b8cb6763a4581b09750130b2ef8ea.jpg",0,0));
        dataSSD.put("18", new Product("18", "Ổ cứng SSD Kingston KC2500 250GB PCIe Gen 3.0", SSD,SSD, "OcungSSDKingstonKC2500250GBPCIeGen3.0/gearvn-o-cung-ssd-kingston-kc2500-1_09475a9973924294b3402bb6383444e3.jpg",0,0));
        dataSSD.put("19", new Product("19", "Ổ cứng SSD Kingston KC2500 500GB PCIe Gen 3.0", SSD,SSD, "OcungSSDKingstonKC2500500GBPCIeGen3.0/gearvn-o-cung-ssd-kingston-kc2500-1_09475a9973924294b3402bb6383444e3.jpg",0,0));
        dataSSD.put("20", new Product("20", "Ổ cứng SSD Plextor M8V 128G", SSD,SSD, "OcungSSDPlextorM8V128G/gearvn-o-cung-ssd-plextor-m8v-128g-1_579c5cf6ac78467c8af99f5bf06fe52e_grande.png",0,0));
        dataSSD.put("21", new Product("21", "Ổ cứng SSD Western Digital Green M.2 Sata III 2280 240G (WDS240G2G0B)", SSD,SSD, "OcungSSDWesternDigitalGreenM.2SataIII2280240G(WDS240G2G0B)/-cung-ssd-western-digital-green-ssd-m-2-sata-iii-2280-240g-wds240g2g0b_634beb3f661148c3a37b2eb87d5bee46.png",0,0));
    }

    public static Map<String, Product> dataHDD = new HashMap<>();
    static {
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
        dataHDD.put("", new Product("", "", HDD,HDD,"", 0,0));
    }
    public static Map<String, Product> dataRAM = new HashMap<>();
    static {
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
        dataRAM.put("", new Product("", "", RAM, RAM, "", 0,0));
    }
    public static Map<String, Product> dataVGA = new HashMap<>();
    static {
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
        dataVGA.put("", new Product("", "", VGA, VGA, "", 0,0));
    }
}
