## DataBinding

**Layouts in DataBinding**<br/>

1.Data binding layout files are slightly different and start with a root tag of layout followed by a data element and a view root element. 
````
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="user" type="com.example.User"/>
   </data>
   
</layout>
````
**Why should I add layout all the way to the top?**<br/>
* When you define layout tag in xml its conveys the compiler special meaning data binding using used it.
* Name of the class is exactly the same name of your xml camel case appended with the binding at the end.<br/>
Example:Xml name is activity_main then it generate the class with the name `ActivityMainBinding`.

**Advantage of adding layout tag in xml:**<br/>
Well there are lots of libraries just to avoid using findViewById() one of the most common is ButterKnife.
Now as you have added data binding there is no need to use findViewById(). As I said before that a separate class is generated with same name as xml 
appended with Binding so

**How to avoid findViewById():**<br/>
 onCreate method initialize the data binding object by using DataBindingUtil than use that object to access all your views directly.

**How it access cal xml id in class():**<br/>
If you have a textview in your xml with the id tv_name then all you need to do in your activity class is just to 
call mainBinding.tvName<br/>

**How it reduces the code?**<br/>
If we have edit text for that we are writing traditional code for set text and text watcher but data binding just create model class with the observable field and
make public them work.<br/>

`public ObservableField<String> name = new ObservableField<>();`
 
**Why ObservableField?**<br/>
It sets the field with observable which continuously monitors for any changes in the contents.<br/>

**No getters and setters?**<br/>
The ObservableField does have a set and get method. So there is no need to use getters and setters. 
You may use like name.set(“Jack”) and name.get() to retrieve value.<br/>

**XML:**<br/>
In xml add a special tag called data and then use variable tag to declare the variable for your model class.
````
<data>
    <variable
        name="registration"
        type="com.example.RegistrationModel"/>
</data>
````
**What ?: is doing in xml?**<br/>

Now directly set the values from xml itself using the name of the object

What if I need to set text watcher?
Do single modification that is change @{} to @={} 
After using set method the value automatically gets reflected to the UI.
````
one-way and two-way databinding?
one-way -> "@{}"
two-way -> "@={}" 
````
**What is One Way DataBinding and Two Way DataBinding It's makes really confusing?**
* One way DataBinding
So Now It’s named one-way databinding because there’s only one communication way: from observable to view.
It Mean's once we pass our object, every property/variable of our object is attached, binded, to one of the UI elements in the Activity/Fragment.
This is one way databinding, the values are bind only once, and if they change or the UI change, nothing happens. 
Object -> View
* Two Way DataBinding
On the other hand, two way databinding means that when the value of the object changes, the UI changes, and when the UI changes, the value in the object changes. 
It’s a two way street.
Object -> View, View -> Object
````
android:text="@{registration.name}"

android:text="@{String.valueOf(registration.name)}"
````

**Common features**
* Mathematical + - / * %
* String concatenation +
* Logical && ||
* Binary & | ^
* Unary + - ! ~
* Shift >> >>> <<
* Comparison == > < >= <= (Note that < needs to be escaped as &lt;)
* instanceof
* Grouping ()
* Literals - character, String, numeric, null
* Cast
* Method calls
* Field access
* Array access []
* Ternary operator ?:

**Missing operations**

* this
* super
* new
* Explicit generic invocation

**Null coalescing operator**<br/>
The null coalescing operator (??) chooses the left operand if it isn't null or the right if the former is null.

android:text="@{user.displayName ?? user.lastName}"

**Collections**<br/>

android:text="@{map[key]}"
android:text="@{list[index]}"<br/>


**Method references**<br/>

android:onClick="@{handlers::onClickFriend}
````
class MyHandlers {
    fun onClickFriend(view: View) { ... }
} 


 
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
   <data>
       <variable name="handlers" type="com.example.MyHandlers"/>
       <variable name="user" type="com.example.User"/>
   </data>
   <LinearLayout
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       <TextView android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@{user.firstName}"
           android:onClick="@{handlers::onClickFriend}"/>
   </LinearLayout>
</layout>
````

**Listener bindings**<br/>
````
class Presenter {
    fun onSaveClick(task: Task){}
}

<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable name="task" type="com.android.example.Task" />
        <variable name="presenter" type="com.android.example.Presenter" />
    </data>
    <LinearLayout android:layout_width="match_parent" android:layout_height="match_parent">
        <Button android:layout_width="wrap_content" android:layout_height="wrap_content"
        android:onClick="@{() -> presenter.onSaveClick(task)}" />
    </LinearLayout>
</layout>
````
**Databinding Image Loading Glide**<br/>
**XML Class Specification**<br/>
`bind:imageUrl="@{employee.profImage}"`<br/>

`imageUrl` is bindingAdapter to identifying bind value in xml<br/>
**Kotlin**
````
 companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageUrl(imageView: ImageView,url: String) {
            Glide.with(imageView).load(url)
                .apply(RequestOptions().placeholder(R.drawable.add_photo_female).error(R.drawable.add_photo_female))
                .into(imageView)
        }
    }
    
 ````


