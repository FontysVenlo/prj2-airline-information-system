<script>
    import {onDestroy, onMount} from "svelte";
    import { api } from '$lib/api';

    let isOpen = $state(false);
    let newCustomer = $state({firstName: '', lastName: '', dateOfBirth: ''});
    let customers = $state([]);

    onMount(() => {
        if(typeof window !== "undefined") {
            window.addEventListener("keydown", handleKeyEvent);
        }
        load();
    })

    onDestroy(() => {
        if(typeof window !== "undefined") {
            window.removeEventListener("keydown", handleKeyEvent);
        }
    })

    const load = async () => {
        customers = await api.all('/customers');
    }

    const handleKeyEvent = (e) => {
        if(e.key === 'Escape' && isOpen) {
            isOpen = false;
        }
    }

    const formatBirthdate = (birthdateArray) => {
        const [year, month, day] = birthdateArray;
        const date = new Date(Date.UTC(year, month - 1, day));
        return date.toISOString().split('T')[0];
    }

    const createCustomer = async (e) => {
        e.preventDefault();
        await api.create("/customers", JSON.stringify(newCustomer));
        // TODO: error handling

        // Reset the customer
        newCustomer.dateOfBirth = '';
        newCustomer.firstName = '';
        newCustomer.lastName = '';

        // Load the customers
        await load();
        isOpen = false;
    }
</script>

<nav class="flex mt-2 mb-2" aria-label="Breadcrumb">
    <ol class="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
        <li class="inline-flex items-center">
            <a href="/" class="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 ">
                <svg class="w-3 h-3 me-2.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                    <path d="m19.707 9.293-2-2-7-7a1 1 0 0 0-1.414 0l-7 7-2 2a1 1 0 0 0 1.414 1.414L2 10.414V18a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v4a1 1 0 0 0 1 1h3a2 2 0 0 0 2-2v-7.586l.293.293a1 1 0 0 0 1.414-1.414Z"/>
                </svg>
                Home
            </a>
        </li>
        <li>
            <div class="flex items-center">
                <svg class="rtl:rotate-180 w-3 h-3 text-gray-400 mx-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 6 10">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 9 4-4-4-4"/>
                </svg>
                <a href="/customers" class="ms-1 text-sm font-medium text-gray-700 hover:text-blue-600 md:ms-2">Customers</a>
            </div>
        </li>
    </ol>
</nav>

<!-- Modal toggle -->
<div class="flex flex-row-reverse m-2">
    <button onclick={() => isOpen = !isOpen } class="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
        Add customer
    </button>
</div>

<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table class="w-full text-sm text-left rtl:text-right text-gray-900">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 ">
        <tr>
            <th scope="col" class="px-6 py-3">
                Name
            </th>
            <th scope="col" class="px-6 py-3">
                Day of birth
            </th>
            <th scope="col" class="px-6 py-3">
                Action
            </th>
        </tr>
        </thead>
        <tbody>
        {#each customers as customer }
        <tr class="odd:bg-white even:bg-gray-50 border-gray-200 font-medium">
            <th class="px-6 py-4">
                { customer.lastName }, { customer.firstName }
            </th>
            <td class="px-6 py-4">
                { formatBirthdate(customer.dateOfBirth) }
            </td>
            <td class="px-6 py-4">
                <a href="/customers/{ customer.id }" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
            </td>
        </tr>
        {/each}
        </tbody>
    </table>
</div>

<div onclick={() => isOpen = !isOpen } id="crud-modal" tabindex="-1" aria-hidden="true" class="{isOpen ? '' : 'hidden'} backdrop-blur-xs flex overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
    <div role="none" class="relative p-4 w-full max-w-md max-h-full" onclick="{ (event) => event.stopPropagation() }" >
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow-sm dark:bg-gray-700">
            <!-- Modal header -->
            <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600 border-gray-200">
                <h3 class="text-lg font-semibold text-gray-900 dark:text-white">
                    Create New Product
                </h3>
                <button onclick={() => isOpen = false } type="button" class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-toggle="crud-modal">
                    <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"/>
                    </svg>
                    <span class="sr-only">Close modal</span>
                </button>
            </div>
            <!-- Modal body -->
            <form class="p-4 md:p-5" onsubmit={ createCustomer }>
                <div class="grid gap-4 mb-4 grid-cols-2">
                    <div class="col-span-2">
                        <label for="firstName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">First name</label>
                        <input type="text" name="firstName" id="firstName" placeholder="First name" required=""  bind:value={ newCustomer.firstName } class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500">
                    </div>
                    <div class="col-span-2">
                        <label for="lastName" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Last name</label>
                        <input type="text" name="lastName" id="lastName" placeholder="First name" required="" bind:value={ newCustomer.lastName } class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500">
                    </div>
                    <div class="col-span-2 sm:col-span-1">
                        <label for="dateOfBirth" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Date of birth</label>
                        <input type="date" name="dateOfBirth" id="dateOfBirth" bind:value={ newCustomer.dateOfBirth } class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500" placeholder="$2999" required="">
                    </div>
                </div>
                <button type="submit" class="text-white inline-flex items-center bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    <svg class="me-1 -ms-1 w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M10 5a1 1 0 011 1v3h3a1 1 0 110 2h-3v3a1 1 0 11-2 0v-3H6a1 1 0 110-2h3V6a1 1 0 011-1z" clip-rule="evenodd"></path></svg>
                    Add new customer
                </button>
            </form>
        </div>
    </div>
</div>