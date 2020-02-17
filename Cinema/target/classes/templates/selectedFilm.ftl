<style>
    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
</style>
<fieldset>
    <legend>Film By ID:</legend>
    <#if film??>
        ${film.toString()}
        <div>
            Director:
            ${film.director.toString()}
        </div>
    </#if>
    <div>
        <br>
        <form action="/" method="get">
            <button type="submit">Back to Main</button>
        </form>
    </div>
</fieldset>