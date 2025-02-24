<script>
    import {onMount} from "svelte";
    import {api} from "$lib/api.js";
    import { page } from '$app/state';

    let customer = $state({});

    onMount(() => {
        load()
    });

    const load = async () => {
        try{
            customer = await api.one("customers", page.params.slug);
        }catch (e) {
            // Handle the error
            console.log(e);
        }
    }
</script>

<h1 class="text-4xl">Customer</h1>

Do something with the customer data here.