<html>
<body>
<style>
    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
</style>


<div align="center">
    <fieldset>
        <table border="1">
            <legend>Directors</legend>
            <thead>
            <tr>
                <td>ID</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Birth Date</td>
                <td>Films</td>
            </tr>
            </thead>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.first_name}</td>
                    <td>${user.last_name}</td>
                    <td>${user.birth_date}</td>
                    <td>
                        <#list user.films as film>
                            <div>
                                ${film.toString()}
                            </div>
                        </#list>
                    </td>
                </tr>
            </#list>
        </table>
        <br>
        <div>
            <form action="/" method="get">
                <button type="submit">Back to Main</button>
            </form>
        </div>
    </fieldset>
</div>

</body>
</html>


