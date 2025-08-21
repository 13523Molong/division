# Works Card List

This project is a React application that displays a list of work items in a card format. Each card shows a title, description, and an image, with a hover effect that enlarges the image for better visibility. The application is structured to be modular and reusable, utilizing functional components and SCSS for styling.

## Project Structure

```
works-card-list
├── src
│   ├── components
│   │   ├── Card
│   │   │   ├── Card.tsx          # Functional component for individual work cards
│   │   │   └── Card.module.scss   # Styles for Card component
│   │   ├── CardList
│   │   │   ├── CardList.tsx      # Functional component to list all work cards
│   │   │   └── CardList.module.scss # Styles for CardList component
│   │   └── Grid
│   │       ├── Grid.tsx          # Functional component for grid layout
│   │       └── Grid.module.scss   # Styles for Grid component
│   ├── data
│   │   └── worksData.ts          # Mock data for work items
│   ├── App.tsx                   # Main application component
│   ├── index.tsx                 # Entry point for React application
│   ├── types
│   │   └── index.ts              # TypeScript types and interfaces
│   └── styles
│       └── global.scss           # Global styles for the application
├── package.json                   # npm configuration file
├── tsconfig.json                  # TypeScript configuration file
└── README.md                      # Project documentation
```

## Features

- **Responsive Design**: The application is designed to be responsive, adapting to different screen sizes.
- **Hover Effects**: Cards have hover effects that enhance user interaction.
- **Reusable Components**: Components are designed to be reusable, promoting maintainability and scalability.
- **TypeScript Support**: The project uses TypeScript for type safety and better development experience.

## Getting Started

1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd works-card-list
   ```
3. Install dependencies:
   ```
   npm install
   ```
4. Start the development server:
   ```
   npm start
   ```

## License

This project is licensed under the MIT License.