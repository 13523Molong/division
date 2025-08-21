export type WorkItem = {
  id: number;
  title: string;
  image: string;
  description: string;
  budget?: number;
  dueDate?: string;
};