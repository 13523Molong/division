const worksData = Array.from({ length: 16 }, (_, i) => {
  const id = i + 1;
  return {
    id,
    title: `Project ${id}`,
    description: `This is a description for project ${id}.`,
    image: `/images/${id}.jpg`,
  };
});

export default worksData;