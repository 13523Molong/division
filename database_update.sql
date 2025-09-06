-- 为requirements表添加新字段
ALTER TABLE requirements 
ADD COLUMN budget DECIMAL(10,2) COMMENT '预算金额',
ADD COLUMN due_date DATE COMMENT '交付日期',
ADD COLUMN budget_min DECIMAL(10,2) COMMENT '预算最小值',
ADD COLUMN budget_max DECIMAL(10,2) COMMENT '预算最大值',
ADD COLUMN date_start DATE COMMENT '交付开始日期',
ADD COLUMN date_end DATE COMMENT '交付结束日期';

-- 查看表结构
DESCRIBE requirements;
