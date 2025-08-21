import React, { useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
import styles from "./PublishPage.module.scss";
import { WorkItem } from "../../types"; 

type FormData = Pick<WorkItem, "title" | "description"> & {
  budget: number;
  dueDate: string;
};

const PublishPage: React.FC = () => {
  const { register, handleSubmit, reset, formState: { errors } } = useForm<FormData>();
  const [success, setSuccess] = useState(false);

  const onSubmit = async (data: FormData) => {
    try {
      await axios.post("http://localhost:3001/posts", data);
      setSuccess(true);
      reset();
    } catch (err) {
      console.error("发布失败", err);
      setSuccess(false);
    }
  };

  return (
    <div className={styles.container}>
      <h2>发布需求</h2>
      <form onSubmit={handleSubmit(onSubmit)} className={styles.form}>
        <div className={styles.field}>
          <label>标题</label>
          <input {...register("title", { required: "标题不能为空" })} />
          {errors.title && <span>{errors.title.message}</span>}
        </div>
        <div className={styles.field}>
          <label>预算</label>
          <input type="number" {...register("budget", { required: "预算不能为空" })} />
          {errors.budget && <span>{errors.budget.message}</span>}
        </div>
        <div className={styles.field}>
          <label>交付日期</label>
          <input type="date" {...register("dueDate", { required: "交付日期不能为空" })} />
          {errors.dueDate && <span>{errors.dueDate.message}</span>}
        </div>
        <div className={styles.field}>
          <label>描述</label>
          <textarea {...register("description", { required: "描述不能为空" })} />
          {errors.description && <span>{errors.description.message}</span>}
        </div>
        <button type="submit">发布</button>
      </form>
      {success && <p className={styles.success}>发布成功 🎉</p>}
    </div>
  );
};

export default PublishPage;