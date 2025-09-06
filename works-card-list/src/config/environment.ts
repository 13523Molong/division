// 环境配置文件
interface EnvironmentConfig {
    API_BASE_URL: string;
    NODE_ENV: string;
}

// 根据当前环境获取配置
const getEnvironmentConfig = (): EnvironmentConfig => {
    const isDevelopment = process.env.NODE_ENV === 'development';

    return {
        API_BASE_URL: isDevelopment
            ? 'http://localhost:8080'  // 开发环境
            : 'http://localhost:8080', // 生产环境（可以根据需要修改）
        NODE_ENV: process.env.NODE_ENV || 'development'
    };
};

export const env = getEnvironmentConfig();
