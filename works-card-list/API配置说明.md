# API配置说明

## 配置架构

本项目采用统一的API配置管理，避免在代码中硬编码端口号和URL。

### 文件结构
```
src/config/
├── environment.ts    # 环境配置
├── api.ts           # API端点配置
└── index.ts         # 统一导出（可选）
```

## 配置说明

### 1. 环境配置 (environment.ts)
```typescript
interface EnvironmentConfig {
  API_BASE_URL: string;  // API基础URL
  NODE_ENV: string;      // 当前环境
}
```

**当前配置**:
- 开发环境: `http://localhost:8080`
- 生产环境: `http://localhost:8080` (可根据需要修改)

### 2. API配置 (api.ts)
```typescript
export const API_CONFIG = {
  BASE_URL: env.API_BASE_URL,
  ENDPOINTS: {
    CREATE_REQUIREMENT: '/createRequirement',
    LOGIN: '/login',
    REGISTER: '/register',
    GET_USERS: '/hello',
    GET_WORKS: '/page'
  }
};
```

## 使用方法

### 在组件中使用
```typescript
import { getApiUrl, API_CONFIG } from '../../config/api';

// 发送请求
const response = await axios.post(
  getApiUrl(API_CONFIG.ENDPOINTS.CREATE_REQUIREMENT), 
  data
);
```

### 获取完整URL
```typescript
// 结果: http://localhost:8080/createRequirement
const url = getApiUrl(API_CONFIG.ENDPOINTS.CREATE_REQUIREMENT);
```

## 修改端口配置

### 方法1: 修改环境配置文件
编辑 `src/config/environment.ts`:
```typescript
API_BASE_URL: isDevelopment 
  ? 'http://localhost:3001'  // 改为你需要的端口
  : 'http://localhost:3001',
```

### 方法2: 使用环境变量
创建 `.env` 文件:
```env
REACT_APP_API_BASE_URL=http://localhost:3001
```

然后修改 `environment.ts`:
```typescript
API_BASE_URL: process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080'
```

## 优势

1. **统一管理**: 所有API配置集中在一个地方
2. **易于维护**: 修改端口只需改一个文件
3. **环境区分**: 支持开发/生产环境不同配置
4. **类型安全**: 完整的TypeScript类型支持
5. **避免硬编码**: 代码中不出现具体的端口号

## 注意事项

1. 修改配置后需要重启前端服务
2. 确保后端服务端口与配置一致
3. 生产环境部署时需要相应修改配置
4. 建议将生产环境配置放在环境变量中
