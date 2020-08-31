# SimpleViewHolders
Android library containing a concrete ViewHolder that doesn't require extending it to use.   It also contains a simple view holder that sets up the View Holder root view for clicks.

[![](https://jitpack.io/v/fsk-software/SimpleViewHolders.svg)](https://jitpack.io/#fsk-software/SimpleViewHolders)

To use the library add jitpack to the projects repositories: 
 
   ```gradle
   repositories { 
        maven { url "https://jitpack.io" }
   }
   ```
   
Then add the following the library to your modules gradle file
   ```
   dependencies {
         implementation 'com.github.fsk-software:SimpleViewHolders:Tag'
   }
   ```  

To use the SimpleViewHolder, just inflate your view directly into it:
    
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LayoutInflater.from(parent.context).let {
            SimpleViewHolder(it.inflate(R.layout.item_missing_items_header, parent, false))
        }


To use the OnItemClickViewHolder, just inflate your view directly into it and provide the on item click lambda:
    
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LayoutInflater.from(parent.context).let {
            OnItemClickViewHolder(it.inflate(R.layout.item_missing_items_header, parent, false))
            { position ->
               //handle click from the position
            }
        }



License
=======
    Copyright 2020 FSK Consulting, Inc

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
