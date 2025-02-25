# Frontend

This is the frontend starter for project 2.

It uses quite a lot of new components, so please take your time to read the following resources:

- [Vite](https://vite.dev/): build system for the frontend
- [Svelte](https://svelte.dev/docs/svelte/overview): The frontend JavaScript library that we will be using. Please make sure you understand how to use Svelte.
- [SvelteKit](https://svelte.dev/docs/kit/introduction): Framework that makes developing web applications easier/faster. For example you get [file-based routing](https://svelte.dev/docs/kit/routing)
- [Fetch](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch): We will be using fetch for making request to the REST API
- [Tailwind](https://tailwindcss.com/): Tailwind is used as the CSS library. However you can use any css library that you want to use, e.g. [Bootstrap](https://getbootstrap.com/), [Bulma](https://bulma.io/), etc.

## Setting up

1. First add a `.env` file in the root of the frontend application (`/frontend/.env`), in here specifiy the base path to the API using the key `PUBLIC_API_BASE`

```bash
# Default base path
PUBLIC_API_BASE="http://localhost:8080/api/v1"
```
2. Install [Node.js and npm](https://nodejs.org/en)
3. Install needed dependencies using npm, run `npm install` in the frontend root directory
4. Start the frontend application `npm run dev`, this will start a server and watch for any file changes. All changes will autoupdate the application and are immediately visible.
5. Go to http://localhost:5173 and you should see a simple starter application

> [!IMPORTANT]
> Please follow the tutorial for SvelteKit [https://svelte.dev/tutorial/kit/introducing-sveltekit](https://svelte.dev/tutorial/kit/introducing-sveltekit)

## Developing

You are free to develop the frontend in the way you prefer.

- Use your own CSS or use a library
- Build your own components or use a library (e.g. [Flowbite](https://flowbite-svelte.com/))
- If you prefer to use [Typescript](https://www.typescriptlang.org/) that is also allowed

> [!IMPORTANT]
> The focus of project 2 is on the backend, **NOT** the frontend.