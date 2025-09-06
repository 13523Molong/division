# Tera Frontend - 全栈作品展示与需求发布平台

[![React](https://img.shields.io/badge/React-18.0-blue.svg)](https://reactjs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.x-green.svg)](https://spring.io/projects/spring-boot)
[![TypeScript](https://img.shields.io/badge/TypeScript-4.x-blue.svg)](https://www.typescriptlang.org/)
[![MySQL](https://img.shields.io/badge/MySQL-5.7+-orange.svg)](https://www.mysql.com/)

一个现代化的全栈作品展示与需求发布平台，采用 React + Spring Boot 技术栈，提供信息流展示、需求发布、用户交互等核心功能。

## 🎯 项目特色

- **🚀 现代化技术栈**: React 18 + TypeScript + Spring Boot + MySQL
- **📱 响应式设计**: 完美适配桌面端和移动端
- **⚡ 高性能体验**: 懒加载、骨架屏、无限滚动
- **🎨 精美界面**: 现代化 UI 设计，流畅的动画效果
- **🔧 完整功能**: 作品展示、需求发布、用户管理

## 📁 项目结构

```
Tera-frontend/
├── src/                    # Spring Boot 后端
│   ├── main/java/         # Java 源码
│   └── main/resources/    # 配置文件
├── works-card-list/       # React 前端
│   ├── src/              # 前端源码
│   ├── public/           # 静态资源
│   └── package.json      # 前端依赖
├── pom.xml               # Maven 配置
└── README.md             # 项目说明
```

## 🚀 快速开始

### 环境要求
- **Node.js** 16.0+
- **Java** 8+
- **MySQL** 5.7+
- **Maven** 3.6+

### 1. 克隆项目
```bash
git clone <repository-url>
cd Tera-frontend
```

### 2. 数据库配置
```sql
CREATE DATABASE tera_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. 启动后端
```bash
# 修改数据库配置
vim src/main/resources/application.yml

# 启动 Spring Boot 应用
./mvnw spring-boot:run
```
后端服务: `http://localhost:8080`

### 4. 启动前端
```bash
cd works-card-list
npm install
npm start
```
前端服务: `http://localhost:3000`

## 🛠 技术栈

### 前端技术
- **React 18** - 用户界面框架
- **TypeScript** - 类型安全
- **SCSS** - 样式预处理
- **React Hook Form** - 表单管理
- **Axios** - HTTP 客户端

### 后端技术
- **Spring Boot 2.x** - Java 后端框架
- **MyBatis** - 数据访问层
- **MySQL** - 关系型数据库
- **Maven** - 项目构建

## ✨ 核心功能

### 🎨 作品展示
- 信息流懒加载
- 无限滚动体验
- 骨架屏加载动画
- 响应式卡片布局

### 📝 需求发布
- 完整表单验证
- 实时错误提示
- 成功/失败反馈
- 数据持久化存储

### 🔍 搜索筛选
- 实时搜索功能
- 标签页切换
- 位置信息显示
- 智能推荐算法

## 📊 项目亮点

### 1. 懒加载实现
使用 `Intersection Observer API` 实现高性能的懒加载机制：

```typescript
const observer = new IntersectionObserver(
  (entries) => {
    if (entries[0].isIntersecting && hasMore && !loading) {
      loadMore();
    }
  },
  { threshold: 0.1 }
);
```

### 2. 表单验证
集成 `React Hook Form` 提供完整的表单验证：

```typescript
const { register, handleSubmit, formState: { errors } } = useForm<FormData>();
```

### 3. API 统一管理
采用配置化的 API 管理方式：

```typescript
export const API_CONFIG = {
  BASE_URL: getEnvironmentConfig().API_BASE_URL,
  ENDPOINTS: {
    CREATE_REQUIREMENT: '/createRequirement'
  }
};
```

## 🎨 界面预览

### 首页 - 作品信息流
- 瀑布流布局展示作品
- 平滑的滚动加载体验
- 精美的卡片悬停效果

### 发布页 - 需求发布
- 现代化的表单设计
- 实时验证和错误提示
- 背景模糊效果

### 移动端适配
- 响应式网格布局
- 触摸友好的交互
- 优化的移动端体验

## 🔧 开发指南

### 代码规范
- 使用 TypeScript 严格模式
- 遵循 ESLint 代码规范
- 采用 SCSS 模块化样式
- 组件化开发模式

### 项目配置
- 统一的 API 配置管理
- 环境变量配置
- 开发/生产环境区分
- 热重载开发体验

## 📈 性能优化

### 前端优化
- 代码分割和懒加载
- 图片优化和压缩
- 缓存策略优化
- 虚拟滚动实现

### 后端优化
- 数据库查询优化
- 连接池配置
- 缓存机制
- 异步处理

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

## 📦 部署

### 开发环境
```bash
# 后端
./mvnw spring-boot:run

# 前端
cd works-card-list && npm start
```

### 生产环境
```bash
# 构建前端
cd works-card-list && npm run build

# 打包后端
./mvnw clean package

# 运行
java -jar target/*.jar
```

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

1. Fork 项目
2. 创建功能分支
3. 提交更改
4. 推送到分支
5. 创建 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 👥 作者

**黄欣芸** - 全栈开发工程师

- GitHub: [@your-username](https://github.com/your-username)
- Email: your-email@example.com

## 🙏 致谢

感谢所有开源项目的贡献者，特别是：
- React 团队
- Spring Boot 团队
- TypeScript 团队
- 所有社区贡献者

---

**注意**: 这是一个学习项目，展示了现代 Web 开发的最佳实践。在生产环境中使用前，请确保进行充分的安全性和性能测试。

## 📚 学习资源

- [React 官方文档](https://reactjs.org/docs)
- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)
- [TypeScript 官方文档](https://www.typescriptlang.org/docs)
- [MySQL 官方文档](https://dev.mysql.com/doc/)

---

**欢迎留言讨论，共同进步！** 🚀