<!DOCTYPE html>
<html lang="en">
<style>
    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
</style>

<fieldset>
    <legend>Search:</legend>
    <div>
        <form action="/filmsByIdAndDate" method="post">
            Enter Director's ID:
            <div>
                <input type="text" name="id" placeholder="${info!}">
            </div>
            Enter Date:
            <div>
                <input type="text" name="date" placeholder="${info!}">
                <button type="submit">Search</button>
            </div>
        </form>
    </div>
    <br>
    <#if films??>
        <#list films as film>
            <div>
                ${film.toString()}
                ${film.director.first_name}
                ${film.director.last_name}
            </div>
        </#list>
    </#if>
    <br>
    <div>
    <form action="/" method="get">
        <button type="submit">Back to Main</button>
    </form>
    </div>
</fieldset>
</html>
