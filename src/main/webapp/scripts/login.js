let userId;

$(document).ready(function () {

    /**
     * Регистрация нового пользователя
     */
    $('#registration_new_user').click(function () {
        let login = $('#registration_login').val();
        let firstName = $('#registration_firstName').val();
        let surname = $('#registration_surname').val();
        let password = $('#registration_password').val();
        if(login!=""&&firstName!==""&&password!==""&&surname!=="") {
            $.ajax({
                type: "POST",
                url: '/users/gamers',
                data: {"login": login, "firstName":firstName, "password": password,"surname":surname},
                success: [function (result) {
                    alert("Успешная регистрация");
                    $('#registration_login').val('');
                    $('#registration_firstName').val('');
                    $('#registration_password').val('');
                    $('#registration_surname').val('');
                    $('#modalRegistration').modal('hide');
                }],
                error: [function () {
                    alert("error");
                }]
            });
        } else {
            alert("Введите все данные!!!")
        }
    });

    /**
     * Авторизация пользователя
     */
  $('#entranсe_button').click( function() {
      let login = $('#login_input').val();
      let pass = $('#password_input').val();

      if(login!=null&&pass!=null) {
          $.ajax({
              type: "post",
              url: '/CardServer/login',
              data: {"login": login, "password": pass},
              success: [function (result) {
                  $('#login_input').val('');
                  $('#password_input').val('');
                // localStorage.setItem('userId', result.data.id);
                //  window.location.href = '../index.html';
                  $(location).attr('href', "http://localhost:8080/CardServer/index.html");
              }],
              error: [function () {
                  alert("неверный логин или пароль");
              }]
          });
      } else {
          alert("Введите все данные!!!")
      }

    });

})






