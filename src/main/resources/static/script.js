document.forms.myForm.addEventListener("submit", function () {
  event.preventDefault();
  let str = document.forms.myForm.taskName.value;
  console.log(str);

  let arr = str.split(",");
  for (const subitem of arr) {
    if (subitem.length > 0) {
      let item = document.createElement("li");
      item.className = "list-group-item";
      // item.innerText = subitem;
      item.innerHTML =
        '<span class="m-1">🗑</span><i class="m-1">✔</i>' + subitem;
      document.querySelector("#myList").append(item);
    }
  }

  document.forms.myForm.reset();
});

document.querySelector("#clear").addEventListener("click", function () {
  document.querySelector("#myList").innerHTML = "";
});

document.querySelector("#myList").addEventListener("click", function () {
  
  if (event.target.tagName == "SPAN") {
    event.target.parentElement.remove();
  } else if (event.target.tagName == "I") {
    console.log(event.target.tagName);
    if (event.target.parentElement.classList.contains("done")) {
      console.log("done")
      event.target.parentElement.classList.remove("done");
    } else {
      console.log("!done")
      event.target.parentElement.classList.add("done");
    }
  }
});
