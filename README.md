项目概述
本项目实现了一个简化的 平台核心功能，包含用户注册登录、作品列表分页查询、需求发布三大模块，重点练习数据库 CRUD 操作和分页查询技术。
1. 用户表（user）
字段名	类型	说明
id	BIGINT	主键（自增）
username	VARCHAR(50)	用户名（唯一）
password	VARCHAR(50)	密码（明文存储）
create_time	DATETIME	创建时间（默认当前时间）
2. 作品表（work）
字段名	类型	说明
id	BIGINT	主键（自增）
title	VARCHAR(100)	作品标题
description	TEXT	作品描述
user_id	BIGINT	作者 ID（关联 user 表）
create_time	DATETIME	创建时间
3. 需求表（requirement）
字段名	类型	说明
id	BIGINT	主键（自增）
title	VARCHAR(100)	需求标题
content	TEXT	需求内容
user_id	BIGINT	发布者 ID（关联 user 表）
create_time	DATETIME	创建时间

src/main/java/com/example/c2c/
├── entity/              // 实体类
│   ├── User.java
│   ├── Work.java
│   └── Requirement.java
├── mapper/              // 数据访问层
│   ├── UserMapper.java
│   ├── WorkMapper.java
│   └── RequirementMapper.java
├── service/             // 业务逻辑层
│   ├── impl/            // 实现类
│   ├── UserService.java
│   ├── WorkService.java
│   └── RequirementService.java
└── controller/          // 接口层
    ├── UserController.java
    ├── WorkController.java
    └── RequirementController.java