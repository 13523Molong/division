import React, { useState } from "react";
import { useForm, SubmitHandler } from "react-hook-form";
import axios from "axios";
import styles from "./PublishPage.module.scss";
import { WorkItem } from "../../types";
import { getApiUrl, API_CONFIG } from "../../config/api";

type FormData = Pick<WorkItem, "title" | "description"> & {
  budget: number;
  dueDate: string;
  budgetMin?: number;
  budgetMax?: number;
  dateStart?: string;
  dateEnd?: string;
};

const PublishPage: React.FC = () => {
  const { register, handleSubmit, reset, formState: { errors } } = useForm<FormData>();
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState<string>("");
  const [isSubmitting, setIsSubmitting] = useState(false);

  const onSubmit: SubmitHandler<FormData> = async (data) => {
    setIsSubmitting(true);
    setError("");
    setSuccess(false);

    try {
      // 转换数据格式以匹配后端API
      const requirementData = {
        title: data.title,
        content: data.description, // 将description映射到content
        publisherId: 1, // 临时硬编码，实际应该从用户登录状态获取
        budget: data.budget,
        dueDate: data.dueDate,
        budgetMin: data.budgetMin || null,
        budgetMax: data.budgetMax || null,
        dateStart: data.dateStart || null,
        dateEnd: data.dateEnd || null
      };

      const response = await axios.post(getApiUrl(API_CONFIG.ENDPOINTS.CREATE_REQUIREMENT), requirementData);

      if (response.data.code === 200) {
        setSuccess(true);
        reset();
        setTimeout(() => setSuccess(false), 3000);
      } else {
        setError(response.data.msg || "发布失败");
      }
    } catch (err: any) {
      setError(err.response?.data?.msg || "网络错误，请稍后重试");
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div className={styles.pageBackground}>
      <div className={styles.container}>
        <h2>发布需求</h2>
        <form onSubmit={handleSubmit(onSubmit)} className={styles.form}>
          <div className={styles.field}>
            <label>标题</label>
            <input
              placeholder="请输入需求标题"
              {...register("title", { required: "标题不能为空" })}
            />
            {errors.title && <span className={styles.error}>{errors.title.message}</span>}
          </div>
          <div className={styles.field}>
            <label>预算</label>
            <input
              type="number"
              placeholder="请输入预算金额"
              {...register("budget", { required: "预算不能为空" })}
            />
            {errors.budget && <span className={styles.error}>{errors.budget.message}</span>}
          </div>
          <div className={styles.field}>
            <label>交付日期</label>
            <input
              type="date"
              {...register("dueDate", { required: "交付日期不能为空" })}
            />
            {errors.dueDate && <span className={styles.error}>{errors.dueDate.message}</span>}
          </div>
          <div className={styles.field}>
            <label>描述</label>
            <textarea
              placeholder="请详细描述您的需求..."
              {...register("description", { required: "描述不能为空" })}
            />
            {errors.description && <span className={styles.error}>{errors.description.message}</span>}
          </div>
          <div className={styles.groupTitle}>筛选功能</div>
          <div className={styles.inlineFields}>
            <div className={styles.field}>
              <label>预算最小值</label>
              <input
                type="number"
                placeholder="最小预算"
                {...register("budgetMin")}
              />
            </div>
            <div className={styles.field}>
              <label>预算最大值</label>
              <input
                type="number"
                placeholder="最大预算"
                {...register("budgetMax")}
              />
            </div>
          </div>
          <div className={styles.inlineFields}>
            <div className={styles.field}>
              <label>交付开始日期</label>
              <input
                type="date"
                {...register("dateStart")}
              />
            </div>
            <div className={styles.field}>
              <label>交付结束日期</label>
              <input
                type="date"
                {...register("dateEnd")}
              />
            </div>
          </div>
          <button type="submit" disabled={isSubmitting}>
            {isSubmitting ? "发布中..." : "发布"}
          </button>
        </form>

        {success && <p className={styles.success}>发布成功 🎉</p>}
        {error && <p className={styles.error}>发布失败: {error}</p>}
      </div>
    </div>
  );
};

export default PublishPage;