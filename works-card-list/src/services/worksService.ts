import { WorkItem } from '../types';

const generateWorksData = (): WorkItem[] => Array.from({ length: 100 }, (_, i) => ({
  id: i + 1,
  title: `Project ${i + 1}`,
  description: `This is a description for project ${i + 1}. It contains more detailed information about the project requirements and goals.`,
  image: `/images/${(i % 16) + 1}.jpg`,
  budget: Math.floor(Math.random() * 10000) + 1000,
  dueDate: new Date(Date.now() + Math.random() * 30 * 24 * 60 * 60 * 1000).toISOString().split('T')[0],
}));

const allWorksData = generateWorksData();

export const worksService = {
  getWorks: async (page: number, pageSize: number = 10) => {
    await new Promise(resolve => setTimeout(resolve, 800 + Math.random() * 400));
    const startIndex = (page - 1) * pageSize;
    const endIndex = startIndex + pageSize;
    const data = allWorksData.slice(startIndex, endIndex);
    return {
      data,
      hasMore: endIndex < allWorksData.length,
      total: allWorksData.length,
    };
  },

  getInitialWorks: async () => {
    await new Promise(resolve => setTimeout(resolve, 500 + Math.random() * 300));
    const initialCount = 12;
    const data = allWorksData.slice(0, initialCount);
    return {
      data,
      hasMore: initialCount < allWorksData.length,
      total: allWorksData.length,
    };
  }
};
