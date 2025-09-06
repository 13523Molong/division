import { env } from './environment';

// API配置文件
export const API_CONFIG = {
    // 后端服务基础URL
    BASE_URL: env.API_BASE_URL,

    // API端点
    ENDPOINTS: {
        CREATE_REQUIREMENT: '/createRequirement',
        LOGIN: '/login',
        REGISTER: '/register',
        GET_USERS: '/hello',
        GET_WORKS: '/page'
    }
};

// 获取完整的API URL
export const getApiUrl = (endpoint: string): string => {
    return `${API_CONFIG.BASE_URL}${endpoint}`;
};

// 导出环境信息，方便调试
export { env };
