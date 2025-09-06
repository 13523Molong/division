# Tera Frontend - 作品展示与需求发布平台

一个现代化的全栈作品展示与需求发布平台，支持信息流风格的懒加载、需求发布、用户交互等功能。

## 🚀 项目概述

Tera Frontend 是一个基于 React + Spring Boot 的全栈应用，提供作品展示、需求发布、用户管理等核心功能。前端采用现代化的信息流设计，后端提供稳定的 API 服务。

## ✨ 功能特性

### 🎯 核心功能
- **信息流懒加载**: 类似微博、知乎、小红书的无限滚动体验
- **需求发布系统**: 完整的表单验证和 API 集成
- **智能分页**: 首屏自动填满，滚动到底部时自动加载新内容
- **骨架屏加载**: 优雅的加载动画和占位效果
- **响应式设计**: 完美适配各种屏幕尺寸

### 📱 页面功能
- **首页**: 作品信息流展示，支持搜索和筛选
- **发布页**: 需求发布表单，支持预算、日期等详细信息
- **创作者页**: 创作者信息展示
- **消息页**: 用户消息管理
- **个人页**: 用户个人信息

### 🎨 界面组件
- **LocationBar**: 位置信息显示
- **SearchBar**: 搜索功能组件
- **TopNav**: 顶部导航标签
- **CardList**: 卡片列表容器，支持懒加载
- **Card**: 作品卡片展示组件
- **SkeletonCard**: 骨架屏占位组件
- **BottomNav**: 底部导航栏

## 🛠 技术栈

### 前端技术
- **React 18**: 使用最新的 React 特性和 Hooks
- **TypeScript**: 完整的类型安全支持
- **SCSS**: 模块化样式管理
- **React Hook Form**: 表单管理和验证
- **Axios**: HTTP 客户端
- **Intersection Observer API**: 实现滚动检测

### 后端技术
- **Spring Boot 2.x**: Java 后端框架
- **MyBatis**: 数据库 ORM 框架
- **MySQL**: 关系型数据库
- **Maven**: 项目构建工具

### 开发工具
- **Webpack**: 模块打包工具
- **ESLint**: 代码质量检查
- **Prettier**: 代码格式化

## 📁 项目结构

```
Tera-frontend/
├── src/                          # Spring Boot 后端源码
│   ├── main/java/com/example/lc/demo/
│   │   ├── controller/           # REST API 控制器
│   │   ├── service/             # 业务逻辑层
│   │   ├── mapper/              # 数据访问层
│   │   └── pojo/                # 数据模型
│   └── main/resources/
│       ├── application.yml       # 应用配置
│       └── logback.xml          # 日志配置
├── works-card-list/              # React 前端项目
│   ├── src/
│   │   ├── components/          # 可复用组件
│   │   │   ├── Card/            # 作品卡片
│   │   │   ├── CardList/        # 卡片列表容器
│   │   │   ├── LocationBar/     # 位置信息栏
│   │   │   ├── SearchBar/       # 搜索栏
│   │   │   ├── SkeletonCard/    # 骨架屏卡片
│   │   │   ├── TopNav/          # 顶部导航
│   │   │   └── BottomNav/       # 底部导航
│   │   ├── pages/               # 页面组件
│   │   │   ├── works/           # 作品页面
│   │   │   ├── publish/         # 发布需求页面
│   │   │   ├── creator/         # 创作者页面
│   │   │   ├── messages/        # 消息页面
│   │   │   └── profile/         # 个人页面
│   │   ├── services/            # 数据服务
│   │   │   └── worksService.ts  # 作品数据 API
│   │   ├── config/              # 配置文件
│   │   │   ├── api.ts           # API 配置
│   │   │   └── environment.ts   # 环境配置
│   │   ├── types/               # TypeScript 类型定义
│   │   └── styles/              # 全局样式
│   ├── public/                  # 静态资源
│   └── package.json             # 前端依赖配置
├── pom.xml                      # Maven 配置
└── README.md                    # 项目说明
```

## 🚀 快速开始

### 环境要求
- Node.js 16+ 
- Java 8+
- MySQL 5.7+
- Maven 3.6+

### 1. 克隆项目
```bash
git clone <repository-url>
cd Tera-frontend
```

### 2. 数据库配置
```sql
-- 创建数据库
CREATE DATABASE tera_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 创建需求表
CREATE TABLE requirements (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    publisher_id INT NOT NULL,
    budget DECIMAL(10,2),
    due_date DATE,
    budget_min DECIMAL(10,2),
    budget_max DECIMAL(10,2),
    date_start DATE,
    date_end DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### 3. 后端启动
```bash
# 修改数据库配置
vim src/main/resources/application.yml

# 启动后端服务
./mvnw spring-boot:run
```
后端服务将在 `http://localhost:8080` 启动

### 4. 前端启动
```bash
cd works-card-list

# 安装依赖
npm install

# 启动开发服务器
npm start
```
前端服务将在 `http://localhost:3000` 启动

## 🔧 配置说明

### API 配置
项目使用统一的 API 配置管理：

```typescript
// works-card-list/src/config/api.ts
export const API_CONFIG = {
  BASE_URL: getEnvironmentConfig().API_BASE_URL,
  ENDPOINTS: {
    CREATE_REQUIREMENT: '/createRequirement',
    GET_REQUIREMENTS: '/getRequirements'
  }
};
```

### 环境配置
```typescript
// works-card-list/src/config/environment.ts
export const getEnvironmentConfig = (): EnvironmentConfig => {
  const isDevelopment = process.env.NODE_ENV === 'development';
  
  return {
    API_BASE_URL: isDevelopment 
      ? 'http://localhost:8080'  // 开发环境
      : 'https://your-api-domain.com'  // 生产环境
  };
};
```

## 📊 核心功能实现

### 懒加载机制
```typescript
// 使用 Intersection Observer API 实现懒加载
useEffect(() => {
  if (initialLoading || loading || !hasMore) return;

  const observer = new IntersectionObserver(
    (entries) => {
      if (entries[0].isIntersecting && hasMore && !loading) {
        loadMore();
      }
    },
    { threshold: 0.1 }
  );

  if (loadingRef.current) {
    observer.observe(loadingRef.current);
  }

  return () => observer.disconnect();
}, [loading, hasMore, loadMore, page, initialLoading]);
```

### 表单验证
```typescript
// 使用 React Hook Form 进行表单管理
const { register, handleSubmit, formState: { errors } } = useForm<FormData>();

const onSubmit: SubmitHandler<FormData> = async (data) => {
  // 表单提交逻辑
  const response = await axios.post(API_URL, data);
  // 处理响应
};
```

## 🎨 样式系统

### SCSS 模块化
```scss
// Card.module.scss
.card {
  background: white;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s ease, box-shadow 0.2s ease;
  
  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);
  }
}
```

### 响应式设计
```scss
// 移动端适配
@media (max-width: 768px) {
  .grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 12px;
  }
}
```

## 🧪 测试

### 前端测试
```bash
cd works-card-list
npm test
```

### 后端测试
```bash
./mvnw test
```

## 📦 构建部署

### 前端构建
```bash
cd works-card-list
npm run build
```

### 后端打包
```bash
./mvnw clean package
```

### Docker 部署
```dockerfile
# Dockerfile 示例
FROM node:16-alpine as frontend-build
WORKDIR /app
COPY works-card-list/package*.json ./
RUN npm install
COPY works-card-list/ ./
RUN npm run build

FROM openjdk:8-jre-alpine
COPY --from=frontend-build /app/build /static
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
```

## 🔍 API 文档

### 需求发布 API
```http
POST /createRequirement
Content-Type: application/json

{
  "title": "项目标题",
  "content": "项目描述",
  "publisherId": 1,
  "budget": 5000,
  "dueDate": "2024-02-15",
  "budgetMin": 3000,
  "budgetMax": 8000,
  "dateStart": "2024-01-01",
  "dateEnd": "2024-01-31"
}
```

### 响应格式
```json
{
  "code": 200,
  "msg": "success",
  "data": {
    "id": 1,
    "title": "项目标题",
    "content": "项目描述"
  }
}
```

## 🐛 常见问题

### 1. 跨域问题
在后端控制器添加 `@CrossOrigin` 注解：
```java
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RequireController {
    // 控制器代码
}
```

### 2. 数据库连接失败
检查 `application.yml` 中的数据库配置：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/tera_db
    username: your_username
    password: your_password
```

### 3. 前端构建失败
确保 Node.js 版本兼容：
```bash
node --version  # 应该 >= 16.0.0
npm --version   # 应该 >= 8.0.0
```

## 🤝 贡献指南

1. Fork 项目
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 👥 作者

- **黄欣芸** - 项目开发 - [GitHub](https://github.com/your-username)

## 🙏 致谢

- React 团队提供的优秀框架
- Spring Boot 团队提供的后端解决方案
- 所有开源贡献者的支持

---

**注意**: 这是一个学习项目，用于展示现代 Web 开发技术栈的集成使用。在生产环境中使用前，请确保进行充分的安全性和性能测试。