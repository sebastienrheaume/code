import cv2 as cv
import numpy
import matplotlib.pyplot as pl
import tensorflow as tf

dataset = tf.keras.datasets.mnist
(x_train, y_train), (x_test, y_test) = dataset.load_data()

x_train = tf.keras.utils.normalize(x_train, axis=1)
x_test = tf.keras.utils.normalize(x_test, axis=1)

model = tf.keras.models.Sequential()
model.add(tf.keras.layers.Flatten(input_shape=(28,28)))
model.add(tf.keras.layers.Dense(units=128, activation=tf.nn.relu))
model.add(tf.keras.layers.Dense(units=128, activation=tf.nn.relu))
model.add(tf.keras.layers.Dense(units=10, activation=tf.nn.softmax))

model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])

model.fit(x_train, y_train, epochs=4)

loss, accuracy = model.evaluate(x_test, y_test)


print((accuracy*100),"%")

print(loss)

model.save('digits.model')


for x in range(1,10):
    image = cv.imread(f'{x}.png')[:,:,0]
    image = numpy.invert(numpy.array([image]))
    pred = model.predict(image)
    print(f'The result is likely: {numpy.argmax(pred)}')
    pl.imshow(image[0], cmap=pl.cm.binary)
    pl.show()