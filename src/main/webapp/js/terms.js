function validate() {
    if (!termscheck.agree.checked){
      alert("이용약관에 동의하지 않았습니다.");
      termscheck.agree.focus();
      return false;
    }
  location.href="register.html";
  return true;
}