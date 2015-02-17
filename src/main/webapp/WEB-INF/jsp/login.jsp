<link rel="stylesheet" href="/resources/css/signin.css">
<div class="container">

      <form class="form-signin" id="login" action="/j_spring_security_check" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="username" class="sr-only">Username</label>
        <input name="j_username" type="text" id="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="j_password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

</div> <!-- /container -->