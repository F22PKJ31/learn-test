package com.f22pkj31.learn.log;

/**
 * skynet 系统，筛选项定义
 *
 * @author xiaojing.xie
 * @create 2019-04-22
 **/
public class SkyNetEnums {
    public SkyNetEnums() {
    }

    /**
     * 日志级别
     */
    public enum LogLevelEnum {
        FATAL("FATAL"),
        ERROR("ERROR"),
        WARN("WARN"),
        WARNING("WARNING"),
        INFO("INFO"),
        DEBUG("DEBUG"),
        TRACE("TRACE");

        private String level;

        LogLevelEnum(String level) {
            this.level = level;
        }

        public String getLevel() {
            return this.level;
        }
    }

    /**
     * 模块-module（天网log筛选-模块列表）
     */
    public enum ModelEnum {
        DCCommand("DCCommand", "直连命令"),
        OrderRequestInfo("OrderRequestInfo", "订单请求"),
        CtripStatic("CtripStatic", "携程静态"),
        AutoMapping("AutoMapping", "自动化mapping"),
        CtripDynamic("CtripDynamic", "携程动态"),
        OrderAudit("OrderAudit", "订单审核"),
        CtripPromotion("Promotion", "携程促销"),
        HotelProperty("HotelProperty", "挂牌"),
        StaticProductTag("StaticProductTag", "静态产品标识"),
        LadderCancellation("LadderCancellation", "阶梯取消"),
        FreeCancellation("FreeCancellation", "30分钟免费取消"),
        TicketPromotion("TicketPromotion", "商家券"),
        RoomPool("RoomPool", "蓄水池"),
        Gift("Gift", "礼包"),
        CityHotelIDs("CityHotelIDs", "城市酒店列表"),
        Other("Other", "其他");

        private String key;
        private String desc;

        ModelEnum(String key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getModel() {
            return this.key;
        }
    }

    /**
     * 大类-category（天网log筛选-大类列表）
     */
    public enum CategorieyEnum {
        ctripData("ctripData", "携程数据"),
        MasterData("MasterData", "内容组数据"),
        cpData("cpData", "产品组数据"),
        rateplan("rateplan", ""),
        drr("drr", ""),
        undefined("", "未定义");


        private String key;
        private String desc;

        CategorieyEnum(String key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getCategoriey() {
            return this.key;
        }
    }

    /**
     * 小类-sub_category（天网log筛选-小类列表）
     */
    public enum SubCategoryEnum {
        logs("logs", "log数据"),
        Inc("Inc", "增量数据"),
        Full("Full", "全量数据"),
        cicpData("cicpData", "携程数据"),
        price("price", "价格数据"),
        status("status", "状态数据"),
        hotel("hotel", "酒店"),
        room("room", "售卖房型"),
        roomType("roomType", "物理房型"),
        checkHotel("checkHotel", "成单校验"),
        detail("detail", "详情"),
        relation("relation", "关系"),
        undefined("", "未定义");


        private String key;
        private String desc;

        SubCategoryEnum(String key, String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getSubCategory() {
            return this.key;
        }
    }
}
