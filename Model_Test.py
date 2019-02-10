
# coding: utf-8

# # Testing Our Dog Breed Classifier Model
# 
# After training our model, we exported the calculated weights so we can test individual samples from our test data.

# In[76]:


#import necessary libraries and load model

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from tqdm import tqdm
from keras.preprocessing import image
from keras.applications.inception_resnet_v2 import preprocess_input, decode_predictions
from keras.models import load_model
import pickle

model = load_model('model.h5')


# In[77]:


#reads csv file of test data
breeds = pd.read_csv("sample_submission.csv")


# In[78]:


#loads one image; index between 0 and 10356
img = breeds['id'][5]

#preprocesses image - normalizes pixel values
mage = image.load_img("test/" + img + ".jpg", target_size=(299, 299))
data = image.img_to_array(mage)
data = preprocess_input(np.expand_dims(mage, axis = 0))

y_pred = model.predict(data)
with open('encoder.pkl','rb') as f:
    one_hot = pickle.load(f)
    f.close()
y_pred


# In[79]:


#returns predicted breed based on output from model
def un_onehot(data):
    breed = one_hot.inverse_transform(data)
    return breed


# In[80]:


#extracts dog's actual breed
breed_actual=np.argmax(y_pred)
breed_actual
breeds_1 = breeds.iloc[0]
breeds_1.to_frame()
breed_list = np.delete(breeds_1.index.values, 0)
breed_list[breed_actual]


# In[81]:


#calculates predicted breed
breed_pred = un_onehot(y_pred)
breed_pred

