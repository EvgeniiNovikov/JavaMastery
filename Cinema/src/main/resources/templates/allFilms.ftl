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
            <legend>Movies</legend>
            <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Genre</td>
                <td>Release Date</td>
                <td>Director</td>
            </tr>
            </thead>
            <#list films as film>
                <tr>

                    <td>${film.id}</td>
                    <td><a href="/movies/${film.id}">
                            ${film.name}
                        </a>
                    </td>
                    <td>${film.genre}</td>
                    <td>${film.release_date}</td>
                    <td><a href="/directors/${film.director.id}">
                    ${film.director.first_name + " " + film.director.last_name}</a></td>
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


