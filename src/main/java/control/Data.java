package control;
import view.*;

import java.util.HashMap;
import java.util.Map;

public class Data {
    public static final String CPU = "CPU";
    public static Map<String, Product> data = new HashMap<>();
    static {
        data.put("01", new Product("01","AMD Athlon™ 200GE 3.2GHz  2 nhân 4 luồng  Radeon™ Vega 3 Graphics",CPU,CPU,"CPU/AMDAthlon200GE3.2GHz24RadeonVega3Graphics/gearvn_cpu_amd.jpg", 1460000, 00));
        data.put("02", new Product("02","AMD Ryzen 3 2200G 3.5 GHz tích hợp VGA Radeon Vega 86MB4 nhân 4 luồng",CPU,CPU,"CPU/AMDRyzen32200G3.5GHzVGARadeonVega86MB44/gearvn_amd_ryzen_3_2200g_3.jpg", 01, 01));
        data.put("03", new Product("03","AMD Ryzen 3 3100 16MB 3.6GHz 4 nhân 8 luồng",CPU,CPU,"CPU/AMDRyzen3310016MB3.6GHz48/amd-ryzen-3-3100_b17cab22e8964140b7883479a7e49c69.png", 01, 01));
        data.put("04", new Product("04","AMD Ryzen 3 3200G 6MB 3.6GHz 4 nhân 4 luồng",CPU,CPU,"CPU/AMDRyzen3310016MB3.6GHz48/amd-ryzen-3-3100_b17cab22e8964140b7883479a7e49c69.png", 01, 01));
        data.put("05", new Product("05","AMD Ryzen 3 3300X 16MB 3.8GHz 4 nhân 8 luồng",CPU,CPU,"CPU/AMDRyzen33300X16MB3.8GHz48/amd-ryzen-3-3100_40c54ff2c14f4561ba2ccc226107a9fd.png", 01, 01));
        data.put("06", new Product("06","AMD Ryzen 5 2400G 3.6 GHz tích hợp VGA Radeon Vega 116MB 4 nhân 8 luồng",CPU,CPU,"CPU/AMDRyzen33300X16MB3.8GHz48/amd-ryzen-3-3100_40c54ff2c14f4561ba2ccc226107a9fd.png", 01, 01));
        data.put("07", new Product("07","AMD Ryzen 5 3400G 6MB 3.7GHz 4 nhân 8 luồng",CPU,CPU,"CPU/AMDRyzen53400G6MB3.7GHz48/19250429-a_2ndgen_ryzen5_radeon_spire_lf_9b6f7158122449be826a7de74844ba0e.png", 01, 01));
        data.put("08", new Product("08","AMD Ryzen 5 3500x 32MB 3.6GHz 6 nhân 6 luồng",CPU,CPU,"CPU/AMDRyzen53500x32MB3.6GHz66/rdgen_ryzen5_stealth_3d_row_bf_c9d40185a9004f6e84b9478234af1875_grande_d0d92d1e111f45dc9a1d201820afd389.png", 01, 01));
        data.put("09", new Product("09","AMD Ryzen 5 3600 36MB 3.6GHz 6 nhân 12 luồng",CPU,CPU,"CPU/AMDRyzen5360036MB3.6GHz612/19257929-a_3rdgen_ryzen5_stealth_3d_row_bf_e85a79f242964714b257e64eeb3931c3.png", 01, 01));
        data.put("10", new Product("10","AMD Ryzen 5 3600x 36MB 3.8GHz 6 nhân 12 luồng",CPU,CPU,"CPU/AMDRyzen53600x36MB3.8GHz612/19257929-a_3rdgen_ryzen5_stealth_3d_row_bf_c9d40185a9004f6e84b9478234af1875.png", 01, 01));
        data.put("11", new Product("11","AMD Ryzen 7 3700x 36MB 3.6GHz 8 nhân 16 luồng",CPU,CPU,"CPU/AMDRyzen73700x36MB3.6GHz816/19239708-a_3rdgenryzen7_row_back_e9298b7cb566479c88d145a872907ecc.png", 01, 01));
        data.put("12", new Product("12","AMD Ryzen 7 3800x 36MB 3.9GHz 8 nhân 16 luồng",CPU,CPU,"CPU/AMDRyzen73800x36MB3.9GHz816/19239708-a_3rdgenryzen7_row_lft_34e6a551fba24c418db7dcdf0eb82d92.png", 01, 01));
        data.put("13", new Product("13","AMD Ryzen 7 5800X  32MB  3.8GHz Boost 4.7GHz  8 nhân 16 luồng",CPU,CPU,"CPU/AMDRyzen75800X32MB3.8GHzBoost4.7GHz816/rvn-cpu-amd-ryzen-7-5800x-32mb-3-8ghz-boost-4-7ghz-8-nhan-16-luong-666_675f75aeff4149f1bd15189673faf87e.png", 01, 01));
        data.put("14", new Product("14","AMD Ryzen 9 3900x 70MB 3.8GHz 12 nhân 24 luồng",CPU,CPU,"CPU/AMDRyzen95900X64MB3.7GHzBoost4.8GHz1224/gearvn-amd-ryzen-9-5900x-64mb-3-7ghz-boost-4-8ghz-12-nhan-24-luong-666_c768e9d619a0477ca7433bd76ffc073c.png", 01, 01));
        data.put("15", new Product("15","AMD Ryzen 9 5900X  64MB  3.7GHz Boost 4.8GHz  12 nhân 24 luồng",CPU,CPU,"CPU/AMDRyzen95900X64MB3.7GHzBoost4.8GHz1224/gearvn-amd-ryzen-9-5900x-64mb-3-7ghz-boost-4-8ghz-12-nhan-24-luong_37c9b8b6804944f7ada5d5630bd57537.png", 01, 01));
    }
}
